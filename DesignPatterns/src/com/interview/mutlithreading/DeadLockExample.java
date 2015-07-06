package com.interview.mutlithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
	private int balance = 100000;

	public void deposit(int amount) {
		this.balance+=amount;
	}

	public void withdraw(int amount) {
		this.balance-=amount;
	}

	public static void transfer(Account a1, Account a2, int amount) {
		a1.withdraw(amount);
		a2.deposit(amount);
	}

	public int getBalance() {
		return balance;
	}
}

class Runner1 {
	Account acc1 = new Account();
	Account acc2 = new Account();

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
        while(true) {
            // Acquire locks
             
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
             
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally {
                if(gotFirstLock && gotSecondLock) {
                    return;
                }
                 
                if(gotFirstLock) {
                    firstLock.unlock();
                }
                 
                if(gotSecondLock) {
                    secondLock.unlock();
                }
            }
             
            // Locks not acquired
            Thread.sleep(1);
        }
    }
	
	public void firstThread() {
		Random random = new Random();
		for(int i =0; i< 1000; i++) {
			try {
				lock1.lock();
				lock2.lock();
//				acquireLocks(lock1, lock2);
				Account.transfer(acc1, acc2, random.nextInt(100));
			} catch (Exception E) {

			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() {
		Random random = new Random();
		for(int i =0; i< 1000; i++) {
			try {
				lock1.lock();
				lock2.lock();
				Account.transfer(acc2, acc1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
}


public class DeadLockExample {
	public static void main(String[] args) {

	}
}
