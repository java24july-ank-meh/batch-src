package com.revature.comparator;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person(3, "ned", 31); // index 0
		Person p2 = new Person(1, "jon", 21); // index 1
		Person p3 = new Person(4, "robb", 18); // index 2
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		for(Person p : persons) {
			System.out.println(p);
		}
		
		Collections.sort(persons, new IdComparator());
		for(Person p : persons) {
			System.out.println(p);
		}

	}

}
