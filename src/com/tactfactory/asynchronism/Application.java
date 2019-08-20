package com.tactfactory.asynchronism;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Application {

    public static void main(String[] args) throws Exception {

//         thread1(2);
//         thread2(20);
//         thread3();

//         CompletableFuturUse.futurExample1();
//         CompletableFuturUse.futurExample2();

        // Prints ForkJoinPool.commonPool-worker-1
        // System.out.println(CompletableFuturUse.futurExample4());
//		try {
//			System.out.println(CompletableFuturUse.futurExample5().get());
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
//		 CompletableFuturUse.futurExample6();
//		 CompletableFuturUse.futurExample7();
        // CompletableFuturUse.futurExample8(3,i-> i * i);
        // CompletableFuturUse.futurExample9();
//        Callable callable1 = new Callable<Void>() {
//
//            @Override
//            public Void call() throws Exception {
//                while(true) {
//                    System.out.println("coucou");
//                }
//            }
//        };
//
//        FutureTask t1 = new FutureTask<>(callable1);
//
//        Callable callable2 = new Callable<Void>() {
//
//            @Override
//            public Void call() throws Exception {
//                while(true) {
//                    System.out.println("hey");
//                }
//            }
//        };
//
//        FutureTask t2 = new FutureTask<>(callable2);
//
//        t1.run();
//        t2.run();

        Callable callable1 = new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                while (true) {
                    System.out.println("coucou");
                }
            }
        };


        ExecutorService pool = Executors.newFixedThreadPool(20);
        int i = 0;
        while (true) {
            i++;
            pool.submit(new MyCallableImpl(i));
            int delta = random.nextInt(16);
            Thread.sleep(delta*1000);
            Thread.sleep(50);
        }

        // System.out.println(future.get());
//        while (true) {
//            System.out.println("hey");
//        }
    }

    static Random random = new Random();

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
                while (true) {
                    System.out.println("false");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println("true");
                }
            }
        });

        System.out.println("Start");
//        t1.start();
////        t2.start();
//        // System.out.println("Run");
//        t1.set
//         t1.start();
//         t2.run();

        // //S1 add
        // System.out.println("Run 2");
        // t1.run();
        // t2.run();
        // //S2 add
        // System.out.println("Start");
        // t1.start();
        // t2.start();
    }

    private static void thread2(int loop) {
//        System.out.println(Thread.currentThread().getName());
//        for (int i = 0; i < 3; i++) {
//            new Thread("" + i) {
//                @Override
//                public void run() {
//                    System.out.println("Thread: " + getName() + " running");
//                }
//            }.start();
//        }
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 stop running");

    }
}
