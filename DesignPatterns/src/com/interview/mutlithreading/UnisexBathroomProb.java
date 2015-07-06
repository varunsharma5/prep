package com.interview.mutlithreading;
import java.util.Collections;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bathroom {
	private Lock lock = new ReentrantLock();
	
	private Condition menWaitingCondition = lock.newCondition();
	private Condition womenWaitingCondition = lock.newCondition();
	
	private int womenWaitingN = 0;
	private int menWaitingN = 0;
	private int womenUsingN = 0;
	private int menUsingN = 0;
	
	private final int BATHROOM_CAPACITY = 3;
	private int free_resources = BATHROOM_CAPACITY;
	
	
	public void manEnters() throws InterruptedException {
		if(free_resources > 0 && womenUsingN == 0) {
			lock.lock();
			menUsingN++;
			free_resources--;
		} else {
			menWaitingN++;
			while(free_resources == 0 && womenUsingN > 0) {
				menWaitingCondition.await();
			}
		}
	}
	
	public void manExists() {
		free_resources--;
		menUsingN--;
		lock.unlock();
		if(free_resources == BATHROOM_CAPACITY && womenWaitingN > 0) {
			womenWaitingCondition.signal();
		}
	}
	
	public void womanEnters() throws InterruptedException {
		lock.lock();
		if(free_resources > 0 && menUsingN == 0) {
			womenUsingN++;
			free_resources--;
		} else {
			womenWaitingN++;
			while(free_resources != 0 && menUsingN > 0) {
				womenWaitingCondition.await();
			}
		}
	}
	
	public void womanExists() {
		womenUsingN--;
		free_resources++;
		if(free_resources == BATHROOM_CAPACITY && menWaitingN > 0) {
			menWaitingCondition.signal();
		}
		lock.unlock();
	}
}



public class UnisexBathroomProb {}
