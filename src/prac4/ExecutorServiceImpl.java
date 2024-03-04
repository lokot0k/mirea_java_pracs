package prac4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorServiceImpl {
    private final int numThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> taskQueue;

    public ExecutorServiceImpl(int numThreads) {
        this.numThreads = numThreads;
        this.threads = new ArrayList<>();
        this.taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    public void submit(Runnable task) {
        taskQueue.offer(task);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}