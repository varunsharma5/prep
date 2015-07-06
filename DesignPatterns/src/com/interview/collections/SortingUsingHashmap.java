package com.interview.collections;

import java.util.HashMap;

class Student {
	private int  rollNum;
	
	public Student(int rolNum) {
		this.rollNum = rolNum;
	}
	
	@Override
	public int hashCode() {
		return rollNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public int getRollNum() {
		return rollNum;
	}
}

public class SortingUsingHashmap {
	public static void main(String[] args) {
		HashMap<Student, Student> list = new HashMap<Student, Student>();
		
		Student s1 = new Student(10);
		list.put(s1, s1);
		
		Student s4 = new Student(13);
		list.put(s4, s4);
		
		Student s2 = new Student(11);
		list.put(s2, s2);
		
		Student s5 = new Student(14);
		list.put(s5, s5);
		
		Student s3 = new Student(12);
		list.put(s3, s3);
		
		for(Student s :list.keySet()) {
			System.out.println(s.getRollNum());
		}
		
	}
}
