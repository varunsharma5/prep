package com.interview.mutlithreading;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerTest {
	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<Integer>();
		
		Thread t1 = new Thread(new GenerateNumber(exchanger));
		Thread t2 = new Thread(new ConsumingNumber(exchanger));
		
		t1.start();
		t2.start();
	}
}

class GenerateNumber implements Runnable {

	Exchanger<Integer> exchanger = null;
	public GenerateNumber(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			try {
				Thread.sleep(1000);
				int i = random.nextInt(1000);
				System.out.println("GenerateNumber.run(): generating number: " + i);
				exchanger.exchange(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


class ConsumingNumber implements Runnable {

	Exchanger<Integer> exchanger = null;
	public ConsumingNumber(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				int i = -1;
				i = exchanger.exchange(i);
				System.out.println("ConsumingNumber.run(): consuming number: " + i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
