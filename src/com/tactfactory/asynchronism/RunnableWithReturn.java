package com.tactfactory.asynchronism;

public class RunnableWithReturn implements Runnable {
    private Integer a = null;

    @Override
    public void run() {
        System.out.println("Run on " + Thread.currentThread().getName());
        this.a = 2;
        AsynV2.latch.countDown();
    }

    public Integer get() {
        return this.a;
    }
}
