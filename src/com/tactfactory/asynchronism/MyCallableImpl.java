package com.tactfactory.asynchronism;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallableImpl implements Callable<Void> {

    private int data;
    private Random random = new Random();

    public MyCallableImpl(int data) {
        this.data = data;
    }

    @Override
    public Void call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" used for iteration " + this.data);

        int delta = random.nextInt(4);
        Thread.sleep(delta*1000);

        return null;
    }

}
