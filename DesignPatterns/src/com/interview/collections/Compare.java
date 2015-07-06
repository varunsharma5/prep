package com.interview.collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Person implements Comparable<Person> {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Person arg0) {
		return name.compareTo(((Person)arg0).getName());
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}
	
}

public class Compare {
	public static void main(String[] args) {
		Person p1 = new Person("varun");
		Person p2 = new Person("arun");
		Person p3 = new Person("rahul");
		Person p4 = new Person("kishore");

		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		NameComparator nameComparator = new NameComparator();
		
		Collections.sort(persons, nameComparator);
		
		System.out.println(persons);
		
	}
}
