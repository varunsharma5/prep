package com.interview.basics;

public class SubclassWithPrivateCtorInSuperClass {

}

class SuperClass1 {
	private static SuperClass1 instance = new SuperClass1(); 
	private SuperClass1() {
	}
	
	public static SuperClass1 getInstance() {
		return instance;
	}
}

/*
 * Multiple markers at this line
	- Implicit super constructor SuperClass() is not visible for default constructor. Must define an explicit 
	 constructor
 */


//class SubClass extends SuperClass1 {
//	
//}
