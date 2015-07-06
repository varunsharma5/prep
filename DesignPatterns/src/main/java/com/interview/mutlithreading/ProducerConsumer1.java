package com.interview.mutlithreading;

import java.util.LinkedList;

class Processor1 {
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		int count = 1;
		while(true) {
			synchronized (lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(count++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized (lock) {
				while(list.size() == 0) {
					lock.wait();
				}
				int n = list.getLast();
				System.out.println("Val: " + n);
				lock.notify();
			}
		}
	}
}

public class ProducerConsumer1 {
	
}
