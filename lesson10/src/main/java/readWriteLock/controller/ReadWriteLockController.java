package readWriteLock.controller;

import readWriteLock.pojo.ReadLockThread;
import readWriteLock.pojo.ReentrantReadWriteLock;
import readWriteLock.pojo.WriteLockThread;

public class ReadWriteLockController {

    public static void main(String[] args) {
        final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        new Thread(new ReadLockThread(reentrantReadWriteLock),"ReadLockThread-1").start();
        new Thread(new WriteLockThread(reentrantReadWriteLock),"WriteLockThread-2").start();
        new Thread(new ReadLockThread(reentrantReadWriteLock),"ReadLockThread-3").start();
        new Thread(new WriteLockThread(reentrantReadWriteLock),"WriteLockThread-4").start();
    }
}
