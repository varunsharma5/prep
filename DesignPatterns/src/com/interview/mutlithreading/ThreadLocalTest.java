package com.interview.mutlithreading;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * We have an object that is not threadsafe and we want to use it safely. We go 
 * for synchronization by enclosing that object in synchronized block. 
 * Other way around is using ThreadLocal, what it does is holds separate 
 * instance for each thread and makes it safe.
 * @author varun
 *
 */

class ThreadLocalDateFormatter {
	private static final ThreadLocal<DateFormat> formatter = new ThreadLocal<DateFormat>() {
		
		@Override
		protected DateFormat initialValue() {
			System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};
	
	public String format(Date date) {
		return formatter.get().format(date);
	}
	
	public static SimpleDateFormat getSimpleDateFormat() {
		return (SimpleDateFormat) formatter.get();
	}
}

public class ThreadLocalTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Task());
		Thread t2 = new Thread(new Task());
		t1.start();
		t2.start();
	}
	
	public static String threadSafeFormat(Date date) {
		DateFormat formatter = ThreadLocalDateFormatter.getSimpleDateFormat();
		return formatter.format(date);
	}
}

class Task implements Runnable {
    
    @Override
    public void run() {
        for(int i=0; i<2; i++){
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + ThreadLocalTest.threadSafeFormat(new Date()) );
        }       
    }
}

