package com.interview.mutlithreading;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class EvenOddUsingLocks {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	
	private Condition evenCond = lock.newCondition();
	private Condition oddCond = lock.newCondition();
	
	public void printEven() throws InterruptedException {
		try {
			lock.lock();
			while(count%2 != 0) {
				evenCond.await();
			}
//			if(count%2 == 0) {
				System.out.println(Thread.currentThread().getName() + " Even Thread, count value: " + count);
				count++;
				oddCond.signal();
//			}
		} finally {
			lock.unlock();
		}
	}
	
	public void printOdd() throws InterruptedException {
		try {
			lock.lock();
			while(count%2 == 0) {
				oddCond.await();
			}
			
//			if(count%2 != 0) {
				System.out.println(Thread.currentThread().getName() + " Odd Thread, count value: " + count);
				count++;
				evenCond.signal();
//			}
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final EvenOddUsingLocks usingLocks = new EvenOddUsingLocks();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						usingLocks.printEven();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						usingLocks.printOdd();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}