package executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTypesExample {
    public static void main(String[] args) {
        // // Single Thread Executor
        // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // for (int i = 0; i < 5; i++) {
        // final int taskId = i;
        // singleThreadExecutor.execute(() -> {
        // System.out.println("Single-Thread Executor: Task " + taskId + " is executing
        // on thread "
        // + Thread.currentThread().getName());
        // });
        // }
        // singleThreadExecutor.shutdown();

        // // Cached Thread Pool
        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // for (int i = 0; i < 5; i++) {
        // final int taskId = i;
        // cachedThreadPool.execute(() -> {
        // System.out.println("Cached Thread Pool: Task " + taskId + " is executing on
        // thread "
        // + Thread.currentThread().getName());
        // });
        // }
        // cachedThreadPool.shutdown();

        // Fixed Thread Pool
        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        // for (int i = 0; i < 5; i++) {
        // final int taskId = i;
        // fixedThreadPool.execute(() -> {
        // System.out.println("Fixed Thread Pool: Task " + taskId + " is executing on
        // thread "
        // + Thread.currentThread().getName());
        // });
        // }
        // fixedThreadPool.shutdown();

        // Scheduled Executor
        // ScheduledExecutorService scheduledExecutor =
        // Executors.newScheduledThreadPool(1);
        // for (int i = 0; i < 3; i++) {
        // final int taskId = i;
        // scheduledExecutor.schedule(() -> {
        // System.out.println("Scheduled Executor: Task " + taskId + " is executing on
        // thread "
        // + Thread.currentThread().getName());
        // }, i + 1, TimeUnit.SECONDS);
        // }
        // scheduledExecutor.shutdown();
    }
}
