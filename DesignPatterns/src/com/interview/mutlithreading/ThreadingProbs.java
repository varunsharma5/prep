package com.interview.mutlithreading;
class Data {

	public static synchronized void func1() {
		System.out.println("Data.func1()");
		try {
			int i = 0;
			while (i++<4) {
				System.out.println("Data.func1():" + Thread.currentThread().getName() + "; waiting ... " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void func2() {
		System.out.println("Data.func2()");
		try {
			int i = 0;
			while (i++<4) {
				System.out.println("Data.func2():" + Thread.currentThread().getName() + "; waiting ... " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void func3() {
		System.out.println("Data.func3()");
	}
	
	public void func4() {
		System.out.println("Data.func4()");
	}

}
public class ThreadingProbs {
	public static void main(String[] args) {
		final Data data = new Data();

		Thread t1 = new Thread(new Runnable() {

			
			@Override
			public void run() {
				data.func1();
			}
		}, "Thread-1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				data.func2();
			}
		}, "Thread-2");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				data.func3();
			}
		}, "Thread-3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
