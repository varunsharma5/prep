package com.interview.mutlithreading.tunning;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class InstrumentedThreadPoolExecutor extends ThreadPoolExecutor{

	public InstrumentedThreadPoolExecutor(int corePoolSize,
			int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	// Keep track of all of the request times
	 private final ConcurrentHashMap<Runnable, Long> timeOfRequest = new ConcurrentHashMap<Runnable, Long>();
	 private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	 private long lastArrivalTime;
	 
	 // other variables are AtomicLongs and AtomicIntegers
	 AtomicLong totalServiceTime = new AtomicLong();
	 AtomicLong totalPoolTime = new AtomicLong();
	 AtomicLong aggregateInterRequestArrivalTime = new AtomicLong();
	 AtomicInteger numberOfRequestsRetired = new AtomicInteger();
	 AtomicInteger numberOfRequests = new AtomicInteger();
	 
	 @Override
	 protected void beforeExecute(Thread worker, Runnable task) {
	   super.beforeExecute(worker, task);
	   startTime.set(System.nanoTime());
	 }

	 @Override
	 protected void afterExecute(Runnable task, Throwable t) {
	   try {
	     totalServiceTime.addAndGet(System.nanoTime() - startTime.get());
	     totalPoolTime.addAndGet(startTime.get() - timeOfRequest.remove(task));
	     numberOfRequestsRetired.incrementAndGet();
	   } finally {
	     super.afterExecute(task, t);
	   }
	 }

	 @Override
	 public void execute(Runnable task) {
	   long now = System.nanoTime();

	   numberOfRequests.incrementAndGet();
	   synchronized (this) {
	     if (lastArrivalTime != 0L) {
	       aggregateInterRequestArrivalTime.addAndGet(now - lastArrivalTime);
	     }
	     lastArrivalTime = now;
	     timeOfRequest.put(task, now);
	   }
	   super.execute(task);
	  }
}
