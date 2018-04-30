package threadPool.pojo;

public class ThreadPool {

    private final BlockingQueue<Runnable> queue;
    private String threadName = null;
    private TaskExecutor task = null;

    public ThreadPool(int queueSize, int nThread) {
        queue = new BlockingQueue<>(queueSize);
        for (int count = 0; count < nThread; count++) {
            threadName = "Thread-"+count;
            task = new TaskExecutor(queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        queue.enqueue(task);
    }
}
