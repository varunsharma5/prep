package com.interview.mutlithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner {
	private int count = 0;
	private Lock lock = new ReentrantLock();

	private void increment() {
		for(int i =0; i< 10000; i++) {
			count++;
		}
	}
	public void firstThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}



public class Locks {
	public static void main(String[] args) throws InterruptedException {
		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.firstThread();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				runner.secondThread();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finished();
	}
}
