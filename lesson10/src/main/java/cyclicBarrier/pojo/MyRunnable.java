package cyclicBarrier.pojo;

public class MyRunnable implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public MyRunnable(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier=cyclicBarrier;
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() +
                " is waiting for all other threads to reach common barrier point");
        try {
            Thread.sleep(1000);
              cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("As all threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");
    }

}
