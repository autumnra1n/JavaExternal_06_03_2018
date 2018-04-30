package threadPool.controller;

import threadPool.pojo.TestTask;
import threadPool.pojo.ThreadPool;

public class ThreadPoolConTroller {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(3,4);
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task);
        }
    }
}
