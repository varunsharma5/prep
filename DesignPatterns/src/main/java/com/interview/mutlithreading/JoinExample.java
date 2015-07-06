package com.interview.mutlithreading;

class MyTask implements Runnable {

	public void run() {
		for (int i=0; i<10; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " Iteration: " + (i+1));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyTask());
		Thread t2 = new Thread(new MyTask());
		Thread t3 = new Thread(new MyTask());
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		System.out.println("Main end");
	}
}
