package reentrantLock.pojo;

public class ReentrantLockCustom {

    private int lockHoldCount;
    private long IdOfThreadCurrentlyHoldingLock;

    public ReentrantLockCustom(){
        lockHoldCount=0;
    }

    public synchronized void lock() {

        if(lockHoldCount==0){
            lockHoldCount++;
            IdOfThreadCurrentlyHoldingLock=Thread.currentThread().getId();
        }
        else if(lockHoldCount>0
                && IdOfThreadCurrentlyHoldingLock==Thread.currentThread().getId()){
            lockHoldCount++;
        }
        else{
            try {
                wait();
                lockHoldCount++;
                IdOfThreadCurrentlyHoldingLock=Thread.currentThread().getId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void unlock() {
        if(lockHoldCount==0)
            throw new IllegalMonitorStateException();

        lockHoldCount--;
        if(lockHoldCount==0)
            notify();
    }
    public synchronized boolean tryLock(){
        if(lockHoldCount==0){
            lock();
            return true;
        }
        else
            return false;
    }
}

