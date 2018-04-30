package readWriteLock.pojo;

public class WriteLockThread implements Runnable{

    private final ReentrantReadWriteLock reentrantReadWriteLock;

    public WriteLockThread(ReentrantReadWriteLock  reentrantReadWriteLock) {
        this.reentrantReadWriteLock = reentrantReadWriteLock;
    }

    public void run(){

        System.out.println(Thread.currentThread().getName()
                +" is Waiting to acquire writeLock");

        reentrantReadWriteLock.lockWrite();

        System.out.println(Thread.currentThread().getName()
                +" has acquired writeLock.");

        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()
                    +" is sleeping.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                +" has released writeLock.");

        reentrantReadWriteLock.unlockWrite();
    }
}

