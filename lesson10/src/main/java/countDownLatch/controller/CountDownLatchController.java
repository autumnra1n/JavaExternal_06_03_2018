package countDownLatch.controller;

import countDownLatch.pojo.CountDownLatchCustom;
import countDownLatch.pojo.MyRunnable;

public class CountDownLatchController {
    public static void main(String[] args) {
        final CountDownLatchCustom countDownLatchCustom = new CountDownLatchCustom(3);
        System.out.println("CountDownLatch has been created with count=3");
        new Thread(new MyRunnable(countDownLatchCustom),"Thread-1").start();
        try {
            countDownLatchCustom.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count has reached zero, "+
                Thread.currentThread().getName()+" thread has ended");
    }
}
