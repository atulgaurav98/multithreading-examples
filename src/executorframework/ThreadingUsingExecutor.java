package executorframework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadingUsingExecutor {
    public static void main(String[] args) {
        // Create a thread pool with a core size of 2, maximum size of 4,
        // a queue size of 10, and a keep-alive time of 1 minute.
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        // Submit tasks to the custom executor.
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is executing on thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor to terminate the threads gracefully.
        executor.shutdown();
    }
}
