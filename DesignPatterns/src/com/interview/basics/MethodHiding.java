package com.interview.basics;
class SuperClass {
	public static void func1(){
		System.out.println("SuperClass.func1()");
		
	}
}

class SubClass extends SuperClass {
	public static void func1(){ /* throws Exception { Compilation Error: Exception Exception is not compatible with throws clause in SuperClass.func1()*/
		System.out.println("SubClass.func1()");
	}
}
public class MethodHiding {
	public static void main(String[] args) {
		System.out.println("Test.main()");
	}
}
