package semaphore.pojo;

public class Semaphore {

    private int permits;

    public Semaphore(int permits) {
        this.permits=permits;
    }

    public synchronized void acquire() throws InterruptedException {
        if(permits > 0){
            permits--;
        }
        else{
            this.wait();
            permits--;
        }
    }

    public synchronized void release() {
        permits++;
        if(permits > 0)
            this.notifyAll();
    }
}

