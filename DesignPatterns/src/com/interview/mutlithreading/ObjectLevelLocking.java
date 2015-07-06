package com.interview.mutlithreading;

class MyClass {
	
	public void increment() {
		synchronized(this) {
			while(true) {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + ": MyClass.increment()");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class ObjectLevelLocking {
	public static void main(String[] args) {
		final MyClass class1 = new MyClass();
		final MyClass class2 = new MyClass();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				class1.increment();
			}
		}, "Thread-One");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				class2.increment();
			}
		},"Thread-Two");
		
		t1.start();
		t2.start();
	}
}
