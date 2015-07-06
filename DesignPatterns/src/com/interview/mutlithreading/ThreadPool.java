package com.interview.mutlithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThread> workerThreads = new ArrayList<PoolThread>();
	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks){
		taskQueue = new LinkedBlockingQueue<Runnable>(maxNoOfTasks);

		for(int i=0; i<noOfThreads; i++){
			workerThreads.add(new PoolThread(taskQueue));
		}
		
		for(PoolThread thread : workerThreads) {
			System.out.println("Starting thread: " + thread.getName());
			thread.start();
		}
	}

	public synchronized void  execute(Runnable task){
		if(this.isStopped) throw
			new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.add(task); //  enqueue(task);
	}

	public synchronized void stop(){
		this.isStopped = true;
		for(PoolThread thread : workerThreads){
			System.out.println("Stopping thread: " + thread.getName());
			thread.stopMe();
		}
	}
	
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(10, 10);
		pool.stop();
	}
}

class PoolThread extends Thread {

	  private BlockingQueue<Runnable> taskQueue = null;
	  private boolean       isStopped = false;

	  public PoolThread(BlockingQueue<Runnable> queue){
	    taskQueue = queue;
	  }

	  public void run(){
	    while(!isStopped()){
	      try{
	        Runnable runnable = (Runnable) taskQueue.poll();
	        if(runnable != null) {
	        	runnable.run();
	        }
	      } catch(Exception e){
	    	  System.out.println("PoolThread.run(): NPE");
	      }
	    }
	  }

	  public synchronized void stopMe(){
	    isStopped = true;
	    this.interrupt(); //break pool thread out of dequeue() call.
	  }

	  public synchronized boolean isStopped(){
	    return isStopped;
	  }
	}
