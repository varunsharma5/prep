package com.interview.basics;

public class StaticAndInitBlock {
	static {
		//Only one time when class is loaded by JVM
		//The static block is loaded when the class is loaded by the JVM for the 1st time only
		System.out.println("This is static block");
	}
	
	{
		//Each time when class is loaded
		//init {} block is loaded every time class is loaded. 
		//Also first the static block is loaded then the init block.
		System.out.println("This is init block");
	}
	public static void main(String[] args) {
		new StaticAndInitBlock();
		new StaticAndInitBlock();
		new StaticAndInitBlock();
	}
}
