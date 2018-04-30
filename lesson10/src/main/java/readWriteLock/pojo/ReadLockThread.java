package readWriteLock.pojo;

public class ReadLockThread implements Runnable {

    private final ReentrantReadWriteLock reentrantReadWriteLock;

    public ReadLockThread(ReentrantReadWriteLock  reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire readLock");

        reentrantReadWriteLock.lockRead();

        System.out.println(Thread.currentThread().getName()
                +" has acquired readLock.");
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()
                    +" is sleeping.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                +" has released readLock.");

        reentrantReadWriteLock.unlockRead();
    }
}
