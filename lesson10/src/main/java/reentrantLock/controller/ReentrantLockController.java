package reentrantLock.controller;

import reentrantLock.pojo.MyRunnable;
import reentrantLock.pojo.ReentrantLockCustom;

public class ReentrantLockController {
    public static void main(String[] args) {
        final ReentrantLockCustom LockCustom = new ReentrantLockCustom();
        final MyRunnable myRunnable = new MyRunnable(LockCustom);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();
    }
}
