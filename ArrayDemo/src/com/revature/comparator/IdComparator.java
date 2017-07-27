package com.revature.comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getId() > o2.getId()) {
			return 1;
		} else if (o1.getId() < o2.getId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
