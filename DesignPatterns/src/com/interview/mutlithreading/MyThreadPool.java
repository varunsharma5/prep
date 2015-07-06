package com.interview.mutlithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
	private final BlockingQueue<Runnable> workerQueue;
	private final Thread[] workerThreads; 

	public MyThreadPool(int numThreads) {
		workerQueue = new LinkedBlockingQueue<Runnable>();
		workerThreads = new Thread[numThreads];

		int threadID = 0;
		for(Thread t : workerThreads) {
			threadID++;
			t = new WorkerThread("Worker-Thread-" + threadID);
			t.start();
		}
	}

	public void addTask(Runnable task) {
		try {
			System.out.println("Task Submitted");
			workerQueue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private class WorkerThread extends Thread {

		public WorkerThread(String threadName) {
			super(threadName);
		}

		@Override
		public void run() {
			while(true) {
				try {
					Runnable task = workerQueue.take();
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		MyThreadPool pool = new MyThreadPool(10);
		
		for(int i =0 ; i < 20; i++) {
			System.out.println("Submitting Task: " + (i+1));
			Runnable task = new Runnable() {
				@Override
				public void run() {
					while(true) {
						System.out.println(Thread.currentThread().getName() + ": Task.run()");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			pool.addTask(task);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

