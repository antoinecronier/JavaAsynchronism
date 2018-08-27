package com.tactfactory.asynchronism;

public class Application {

	public static void main(String[] args) {

		// thread1(2);
		// thread2(20);
		// thread3();

		// CompletableFuturUse.futurExample1();
		// CompletableFuturUse.futurExample2();
		// CompletableFuturUse.futurExample3();
		// System.out.println(CompletableFuturUse.futurExample4());
		// try {
		// System.out.println(CompletableFuturUse.futurExample5().get());
		// } catch (InterruptedException | ExecutionException e) {
		// e.printStackTrace();
		// }
		// CompletableFuturUse.futurExample6();
		// CompletableFuturUse.futurExample7();
		// CompletableFuturUse.futurExample8(3,i-> i * i);
		// CompletableFuturUse.futurExample9();
	}

	private static void thread3() {
		AsynchronismClass c = new AsynchronismClass(10);
		c.addRunnable(new AsynchronismClassExposure() {
			
			@Override
			public void run() {
				c.doAction1(getInt());
			}
			
			@Override
			public Integer getInt() {
				return 5;
			}
		});
		c.addRunnable(new AsynchronismClassExposure() {

			@Override
			public void run() {
				
				
			}

			@Override
			public Integer getInt() {
				return c.getInt();
			}
		});
		c.start();
	}

	private static void thread1(int loop) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < loop; i++) {
					System.out.println("Stuff 1");
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < loop; i++) {
					System.out.println("Stuff 2");
				}
			}
		});
		System.out.println("Start");
		t1.start();
		t2.start();
		System.out.println("Run");
		t1.run();
		t2.run();

		// //S1 add
		// System.out.println("Start");
		// t1.run();
		// t2.run();
		// //S2 add
		// System.out.println("Start");
		// t1.start();
		// t2.start();
	}

	private static void thread2(int loop) {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < loop; i++) {
			new Thread("" + i) {
				public void run() {
					System.out.println("Thread: " + getName() + " running");
				}
			}.start();
		}
	}
}
