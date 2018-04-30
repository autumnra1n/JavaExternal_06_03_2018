package readWriteLock.pojo;

import java.util.concurrent.atomic.AtomicInteger;

public class ReentrantReadWriteLock {

    private int readers;
    private int writers;
    private int writeRequests;

    public synchronized void lockRead() {
        while(writers > 0 || writeRequests > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void lockWrite() {
        writeRequests++;

        while(readers > 0 || writers > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}


