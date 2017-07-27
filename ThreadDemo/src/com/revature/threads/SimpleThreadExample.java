package com.revature.threads;

public class SimpleThreadExample {

	public static void main(String[] args) {
		Runnable job = new MyRunnableClass();
		Thread worker = new Thread(job);
		worker.start();
		for (int i = 0; i<50; i++) {
			System.out.println("main");
		}
	}

}

class MyRunnableClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("MyRunnableClass");
		}
	}

}