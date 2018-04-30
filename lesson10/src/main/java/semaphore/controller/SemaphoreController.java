package semaphore.controller;

import semaphore.pojo.DecrementThread;
import semaphore.pojo.IncrementThread;
import semaphore.pojo.Semaphore;

public class SemaphoreController {

    public static int SharedValue=0;

    public static void main(String[] args) {
        final Semaphore semaphore=new Semaphore(1);
        System.out.println("Semaphore with 1 permit has been created");

        IncrementThread incrementThread=new IncrementThread(semaphore);
        new Thread(incrementThread,"incrementThread").start();

        DecrementThread decrementThread=new DecrementThread(semaphore);
        new Thread(decrementThread,"decrementThread").start();
    }
}
