package com.tactfactory.asynchronism;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynV2 {

    final static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Old code
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run on " + Thread.currentThread().getName());

            }
        };

        Thread to = new Thread(runnable, "My Super Thread");
        to.run();

        to.start();
        to.stop();

        // with Result (and async)
        final RunnableWithReturn runnableResult = new RunnableWithReturn();

        Thread toResult = new Thread(runnableResult, "My Super Thread");
        toResult.run();
        // Je peux faire plein de traitement ici
        // puis je récupère le résultat du thread (blocant si pas fini)
        latch.await();
        Integer resultOld = runnableResult.get();

        // New Code [equivalent to Thread)
        ExecutorService pool = Executors.newSingleThreadExecutor(); // Pool de 1 thread
        pool = Executors.newFixedThreadPool(1);

        // Run "bettement" et tu ne peux plus joué avec le thread => to.start();
        pool.execute(runnable);

        // OR
        // Run mais renvoi une instance de pilotage (sans resultat)
        Future<?> tn = pool.submit(runnable); // => to.start();
        tn.cancel(true); // => to.stop();

        // Meilleur cas avec return

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };

        Future<Integer> tnResult = pool.submit(callable); // => to.start();
        // Je peux faire plein de traitement ici
        // puis je récupère le résultat du thread (blocant si pas fini)
        Integer result = tnResult.get();
    }

}
