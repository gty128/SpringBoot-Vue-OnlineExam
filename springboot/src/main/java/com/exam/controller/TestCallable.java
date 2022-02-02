package com.exam.controller;

import java.util.concurrent.*;

/**
 * @Auther gty
 * @Date 2022/1/11
 */
public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("-----");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable();
        ExecutorService  service = Executors.newFixedThreadPool(1);
        Future<Boolean> f1 = service.submit(t1);
        Boolean rs1 = f1.get();
        service.shutdown();
    }
}
