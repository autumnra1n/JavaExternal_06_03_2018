package semaphore.pojo;

import semaphore.controller.SemaphoreController;

public class DecrementThread implements Runnable {

    private final Semaphore semaphore;

    public DecrementThread(Semaphore semaphore){
        this.semaphore=semaphore;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+
                " is waiting for permit");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+
                    " has got permit");

            for(int i=0;i<5;i++){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+
                        " >"+ SemaphoreController.SharedValue--);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName()+
                " has released permit");
        semaphore.release();


    }
}
