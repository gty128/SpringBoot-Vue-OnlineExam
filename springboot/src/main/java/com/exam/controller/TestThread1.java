package com.exam.controller;

/**
 * @Auther gty
 * @Date 2022/1/11
 */
public class TestThread1 implements Runnable{
    private  int i = 100;
    @Override
    public void run() {
        while (true){
            if(i<=0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----->"+i--);
        }
    }


    public static void main(String[] args) {
      TestThread1 testThread1 =  new TestThread1();
      Thread t1 = new Thread(testThread1,"me");
      Thread t2 = new Thread(testThread1,"he");
      Thread t3 = new Thread(testThread1,"she");
      t1.start();
      t2.start();
      t3.start();
    }
}
