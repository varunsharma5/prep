package com.interview.exceptions;

public class FinallyTest {
	public static void main(String[] args) {
		try {
			System.out.println("Hello");
		} finally {
			System.out.println("1");
			System.out.println("2");
			int i = 0/0;
			System.out.println("3");
			System.out.println("4");
		}
	}
}
