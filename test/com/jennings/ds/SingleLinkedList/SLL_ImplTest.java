package com.jennings.test;

import com.jennings.ds.SLL_Impl;

public class SLL_ImplTest {
	private static long stopwatch;
	private static long timer;

	public static void main(String[] args) {
		//testNewList();
		//testRemoveNode();
		//testRemoveDuplicates();
		//testAddFunctions();
		//testFindKthToLastElement();
		//testRemoveMiddleNodeFromList();
		//testPartitionList();
		//testAddTwoLists();
		testReverse();
	}
	
	public static void testNewList() {
		SLL_Impl list1 = new SLL_Impl();
		SLL_Impl list2 = new SLL_Impl();
		
		list1 = new SLL_Impl();
		//Create SLL with 5 elements, printing each element after adding it
		for(int i = 100; i <= 500; i += 100) {
			list1.add(i);
			list2.addToTail(i);			
		}
		list1.print();
		list2.print();
	}
	
	public static void testRemoveNode() {
		//Create and add SLL with 5 elements
		SLL_Impl list1 = new SLL_Impl();
		for(int i = 1; i <= 5; i++) {
			list1.add(i);
		}
		list1.print();
		list1.remove(5);
		list1.print();
		list1.remove(3);
		list1.print();
	}
	
	public static void testReverse() {
		SLL_Impl list = createList(10);
		list.print();
		list.reverseList();
		list.print();
	}

	public static void testRemoveDuplicates() {
		SLL_Impl list1 = new SLL_Impl();
		SLL_Impl list2 = new SLL_Impl();
		int max = 20000;
		String tester = "JAVA COFFEE CODING POWER";
		for(int i = 0; i <= tester.length() - 1; i ++) {
			list1.addToTail(tester.charAt(i));
			list2.addToTail(tester.charAt(i));
		}
//		for(int i = 0; i <= max; i ++) {
//			list1.addToTail(i % 5000);
//			list2.addToTail(i % 5000);
//		}
		list1.print();
		startTimer();
		list1.removeDuplicates();
		stopTimer();
		list1.print();
		printTimer("Test1: Remove Duplicates - ");

		list2.print();
		startTimer();
		list2.removeDuplicatesWithoutTempBuffer();
		stopTimer();
		list2.print();
		printTimer("Test2: Remove Duplicates without Temp Buffer - ");
	}	
	
	public static void testAddFunctions() {
		SLL_Impl list1 = new SLL_Impl();
		int max = 20000;
			
		//Add 5 elements to front of the list 
		startTimer();
		for(int i = 1; i <= max; i++) {
			list1.addToHead(i);
		}
		stopTimer();		
		printTimer("Test1: Add to Head of List - ");
		
		//Add 5 elements to back of the list 
		startTimer();
		for(int i = 1; i <= max; i++) {
			list1.addToTail(i);
		}
		stopTimer();
		printTimer("Test2: Add to Tail of List (Optimized) - ");
		
		//Add 5 elements to back of the list 
		startTimer();
		for(int i = 1; i <= max; i++) {
			list1.addToTail_Slow(i);
		}
		stopTimer();		
		printTimer("Test3: Add to Tail of List - ");
	}
	
	public static void testFindKthToLastElement() {
		SLL_Impl list = createList(10);
		list.print();
		System.out.println("5th to last element = " + list.findKthToLastElement(5));
		System.out.println("Last to last element = " + list.findKthToLastElement(0));
		System.out.println("1st to last element = " + list.findKthToLastElement(1));
		System.out.println("11th to last element = " + list.findKthToLastElement(11));
	}
	
	public static void testRemoveMiddleNodeFromList() {
		SLL_Impl list = createList(10);
		list.print();
		list.removeMiddleNodeFromList();
		list.print();
		list.removeMiddleNodeFromList();
		list.print();
	}
	
	public static void testPartitionList() {
		SLL_Impl list = createList(10);
		list.print();
		list.partitionList(7);
		list.print();
		
		for(int i = 0; i <= 25; i ++) {
			list.addToTail(i % 12);
		}
		list.print();
		list.partitionList(3);
		list.print();
		list.partitionList(5);
		list.print();
	}
	
	public static void testAddTwoLists() {
		SLL_Impl list1 = new SLL_Impl();
		list1.addToHead(6);
		list1.addToHead(1);
		list1.addToHead(7);
		SLL_Impl list2 = new SLL_Impl();
		list2.addToHead(2);
		list2.addToHead(9);
		list2.addToHead(5);
		SLL_Impl total = list1.addTwoLists(list2);
		list1.print();
		list2.print();
		total.print();
	}
	
	public static SLL_Impl createList(int max) {
		SLL_Impl list = new SLL_Impl();
		for(int i = 1; i <= max; i++) {
			list.addToHead(i);
		}
		return list;
	}
	
	public static void startTimer() {
		timer = 0;
		stopwatch = System.currentTimeMillis();
	}
	
	public static void stopTimer() {
		timer = System.currentTimeMillis() - stopwatch;
		stopwatch = 0;
	}
	
	public static void printTimer(String msg) {
		System.out.println(msg + "Elasped Time in milliseconds: " + timer);
	}
}
