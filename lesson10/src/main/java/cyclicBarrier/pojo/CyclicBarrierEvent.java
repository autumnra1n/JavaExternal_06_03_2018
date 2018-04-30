package cyclicBarrier.pojo;

public class CyclicBarrierEvent implements Runnable{

    public void run() {
        System.out.println("As all threads have reached common barrier point "
                + ", CyclicBarrrierEvent has been triggered");
    }
}
