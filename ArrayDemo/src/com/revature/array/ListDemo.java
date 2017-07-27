package com.revature.array;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(10);
		arrayList.add(3);
		System.out.println("arrayList = " + arrayList);
		System.out.println("arrayList[2] = " + arrayList.get(2));
		
		filter(arrayList);
		System.out.println("arrayList = " + arrayList);
		
		//LinkedList
		List<Integer> listLinkedList = new LinkedList<>(); //only List methods
		Deque<Integer> dequeLinkedList = new LinkedList<>(); //only Deque methods
		Queue<Integer> queueLinkedList = new LinkedList<>(); //only Queue methods
		LinkedList<Integer> normalLinkedList = new LinkedList<>(); //normal

	}
	
	static void filter(Collection<Integer> c) {
		for (Iterator<Integer> it = c.iterator(); it.hasNext();) {
			if(it.next() > 5) {
				it.remove();
			}
		}
	}

}
