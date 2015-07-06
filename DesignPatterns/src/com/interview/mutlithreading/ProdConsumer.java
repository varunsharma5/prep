package com.interview.mutlithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ProdConsumer {

	private Object lock = null;

	public ProdConsumer(Object lock) {
		this.lock = lock;
	}

	private AtomicInteger count = new AtomicInteger(-1);

	public void consume(String name) throws InterruptedException {
		System.out.println(name + ": count " + count);
		synchronized (lock) {
			while (count.get() == -1) {
				System.out.println(name + " :waiting");
				lock.wait();
			}
			// System.out.print(name + ":Consumed " + count);
			count.decrementAndGet();
			System.out.println(name + ": Consumed, new count is " + count);
			lock.notifyAll();
		}
	}

	public void produce(String name) throws InterruptedException {
		System.out.println(name + ": count " + count);
		synchronized (lock) {
			while (count.get() > 5) {
				System.out.println(name + " :waiting");
				lock.wait();
			}
			count.incrementAndGet();
			System.out.println(name + ": Produced, new count is " + count);
			lock.notifyAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final ProdConsumer pc = new ProdConsumer(new Object());
		
		Thread prod = new Thread("Producer") {
			public void run() {
				int i = 0;
				System.out.println("thead-name " + this.getName());
				while (i < 10) {
					System.out.println(">>>>>>>>>>>>> Producer Iteration: " + (i+1));
					try {
						pc.produce(this.getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("Exception occurred");
					}
					i++;
				}
			}
		};
		ThreadGroup tg = new ThreadGroup("Consumers");

		Thread consum = new Thread(tg, "Consumer-1") {
			public void run() {
				int i = 0;
				System.out.println("thread-name " + this.getName());
				while (i < 10) {
					System.out.println(">>>>>>>>>>>>> Consumer1 Iteration: " + (i+1));
					try {
						pc.consume(this.getName());
						
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("Exception occurred");
					}
					i++;
				}
			}
		};

		Thread consum1 = new Thread(tg, "Consumer-2") {
			public void run() {
				int i = 0;
				System.out.println("thread-name " + this.getName());
				while (i < 10) {
					System.out.println(">>>>>>>>>>>>> Consumer2 Iteration: " + (i+1));
					try {
						pc.consume(this.getName());
						i++;
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("Exception occurred");
					}
				}
			}
		};
		consum.start();
		consum1.start();
		prod.start();
	}
}
