package cyclicBarrier.pojo;

public class CyclicBarrier {

    private final int initialParties;
    private int partiesAwait;
    private final Runnable cyclicBarrrierEvent;

    public CyclicBarrier(int parties, Runnable cyclicBarrierEvent) {
        initialParties=parties;
        partiesAwait=parties;
        this.cyclicBarrrierEvent=cyclicBarrierEvent;
    }

    public synchronized void await() throws InterruptedException {
        partiesAwait--;
        if(partiesAwait>0){
            this.wait();
        }
        else{
            partiesAwait=initialParties;
            notifyAll();
            cyclicBarrrierEvent.run();
        }
    }
}
