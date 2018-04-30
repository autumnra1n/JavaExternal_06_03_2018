package cyclicBarrier.controller;

import cyclicBarrier.pojo.CyclicBarrier;
import cyclicBarrier.pojo.CyclicBarrierEvent;
import cyclicBarrier.pojo.MyRunnable;

public class CyclicBarrierController {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3 ,new CyclicBarrierEvent());
        System.out.println("CountDownLatch has been created with parties=3,"
                + " when all 3 parties will reach common barrier point "
                + "CyclicBarrrierEvent will be triggered");

        MyRunnable myRunnable=new MyRunnable(cyclicBarrier);

        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
        new Thread(myRunnable,"Thread-3").start();

    }
}
