package com.interview.mutlithreading;
import java.util.concurrent.Semaphore;


public class SemaphoreTest {
	
	private Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		
		final SemaphoreTest test = new SemaphoreTest();
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					test.criticalSection();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					test.criticalSection();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	
	private void criticalSection() throws InterruptedException {
		semaphore.acquire();
		System.out.println(Thread.currentThread().getName() + ": Entered SemaphoreTest.criticalSection()");
		Thread.sleep(1000);
		semaphore.release();
	}
}
