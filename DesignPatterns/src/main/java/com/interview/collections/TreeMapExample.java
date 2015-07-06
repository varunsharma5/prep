package com.interview.collections;

import java.util.TreeMap;


class MyStudent implements Comparable<MyStudent>{
	private int rollNum;
	private String name;
	public MyStudent(int rollNum, String name) {
		super();
		this.rollNum = rollNum;
		this.name = name;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(MyStudent o) {
		if(rollNum > o.getRollNum()) {
			return 1;
		} else if(rollNum < o.getRollNum()) {
			return -1;
		}
		return 0;
	}
	
	
}
public class TreeMapExample {
	public static void main(String[] args) {
		TreeMap<MyStudent, MyStudent> students = new TreeMap<MyStudent, MyStudent>();
		
		MyStudent s3 = new MyStudent(3, "govind");
		MyStudent s1 = new MyStudent(1, "varun");
		MyStudent s4 = new MyStudent(4, "jinka");
		MyStudent s2 = new MyStudent(2, "arun");
		MyStudent s5 = new MyStudent(5, "raghu");
		
		students.put(s4, s4);
		students.put(s2, s2);
		students.put(s5, s5);
		students.put(s1, s1);
		students.put(s3, s3);
		
		for(MyStudent key : students.keySet()) {
			System.out.println(key.getRollNum() + ": " + students.get(key).getName());
		}
		
	}
}
