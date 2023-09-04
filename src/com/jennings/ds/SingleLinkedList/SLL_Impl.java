package com.jennings.ds.SingleLinkedList;

import java.util.HashSet;

public class SLL_Impl implements SLL {
	MyNode head;
	int length;

	public SLL_Impl() {
		head = null;
	}

	public SLL_Impl(int o) {
		head = new MyNode(o, null);
	}
	
	public void add(int i) {
		addToHead(i);
	}
	
	public void addToHead(int i) {
		MyNode n = new MyNode(i, head);
		head = n;
		length++;
	}
	
	public void addToTail(int i) {
		MyNode n = new MyNode(i, null);
		if (null == head) {
			head = n;
		} else {
			MyNode current = head;
			while (null != current.getNext()) {
				if(null != current.getNext().getNext()) {
					current = current.getNext().getNext();
				} else {
					current = current.getNext();
				}
			}
							
			current.setNext(n);
		}
		length++;
	}
	
	public void addToTail_Slow(int i) {
		MyNode n = new MyNode(i, null);
		if (null == head) {
			head = n;
		} else {
			MyNode current = head;
			while (null != current.getNext()) {
				current = current.getNext();
			}
			current.setNext(n);
		}
		length++;
	}
	
	public boolean remove(int n) {
		if (null == head) {
			return false;
		}
		MyNode current = head;
		if(current.getData() == n) {
			head = head.getNext();
			return true;
		}
		MyNode next = head.getNext();
		
		while (null != next) {
			if (next.getData() == n) {
				current.setNext(next.getNext());
				return true;
			} else {
				current = next;
				next = next.getNext();
			}
		}
		return false;
	}
	
	// Space = BigO(n) && Time = BigO(n)
	public void removeDuplicates() {
		MyNode current = head;
		MyNode previous = null;
		HashSet<Integer> set = new HashSet<>();
		while (null != current) {
			if (set.contains(current.getData())) {
				previous.setNext(current.getNext());
			} else {
				set.add(current.getData());
				previous = current;
			}
			current = current.getNext();
		}
	}
	
	// Space = BigO(1) && Time = BigO(n^2)
	public void removeDuplicatesWithoutTempBuffer() {
		MyNode current = head;
		while (null != current) {
			MyNode runner = current;
			while (runner.getNext() != null) {
				if(runner.getNext().getData() == current.getData()) {
					runner.setNext(runner.getNext().getNext());
				}
				runner = runner.getNext();
			}
			current = current.getNext();
		}
	}
	
	public void reverseList() {
		if (null == head) {
			return;
		}
		MyNode old_head = head;
		MyNode current = head.getNext();
		while (null != current) {
			this.addToHead(current.getData());
			current = current.getNext();
		}
		old_head.setNext(null);
	}
	
	public Integer findKthToLastElement(int k) {
		// Note: If length is not internally stored, loop through the list one time to find it 
		int indexToFind = length() - 1 - k; 
		MyNode current = head;

		while (null != current && indexToFind > 0 ) {
			current = current.getNext();
			indexToFind--;
		}
		if (null != current && indexToFind == 0) {
			return current.getData();
		} else {
			return null;
		}
	}
	
	public void removeMiddleNodeFromList() {
		int middle = length / 2;
		MyNode nodeToRemove = getNode(middle);
		nodeToRemove.setData(nodeToRemove.getNext().getData());
		nodeToRemove.setNext(nodeToRemove.getNext().getNext());
	}
	
	// Method will partition list such that all nodes less than x come before all nodes g.t.o.e.t. x
	public void partitionList(int x) {
		SLL_Impl lessThanList = new SLL_Impl();
		SLL_Impl greaterThanList = new SLL_Impl();
		
		MyNode current = head;
		
		while (null != current) {
			int data = current.getData();
			if (data < x) {
				lessThanList.addToHead(data);
			} else {
				greaterThanList.addToHead(data);
			}
			current = current.getNext();
		}
		current = lessThanList.getNode(lessThanList.length - 1);
		current.setNext(greaterThanList.getNode(0));
		head = lessThanList.head;
	}
	
	public SLL_Impl addTwoLists(SLL_Impl adder) {
		int value1 = parseValueFromList();
		int value2 = adder.parseValueFromList();
		SLL_Impl sum = new SLL_Impl();
		String total = ((Integer)(value1 + value2)).toString();
		for (int i = 0; i < total.length(); i++) {
			sum.addToHead(Integer.valueOf(total.substring(i, i+1)));
		}
		
		return sum;
	}
	
	private int parseValueFromList() {
		MyNode current = head;
		int multiplier = 1;
		int sum = 0;
		while (null != current) {
			sum += current.getData() * multiplier;
			multiplier *= 10;
			current = current.getNext();
		}
		return sum;
	}
	
	public boolean hasCycle() {
		if (null == head) {
			return false;
		}
		MyNode fast = head;
		MyNode slow = head;
		while(null != fast && null != fast.getNext() && null != slow) {
			if (fast == slow) {
				return true;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return false;
	}
	
	public Integer get(int index) {
		MyNode ret = getNode(index);
		return null != ret ? ret.getData() : null;
				
	}
	
	private MyNode getNode(int index) {
		MyNode current = head;
		if (index >= length || index < 0) {
			return null;
		}
		while (null != current && index > 0) {
			current = current.getNext();
			index--;
		}
		return current;
	}
	
	public int length() {
		return length;
	}
	
	public void print() {
		MyNode pointer = head;
		while (pointer != null) {
			System.out.print(pointer.getData().toString() + ' ');
			pointer = pointer.getNext();
		}
		System.out.println();
	}
}

class MyNode {
	private Integer data;
	private MyNode next;

	MyNode(Integer o, MyNode n) {
		data = o;
		next = n;
	}
	
	public MyNode getNext() {
		return next;
	}
	public void setNext(MyNode n) {
		next = n;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer i) {
		data = i;
	}
}
