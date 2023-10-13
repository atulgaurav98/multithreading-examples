import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// pre-requisite Executor framework
public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a thread pool with three worker threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            final int taskNumber = i;
            executorService.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskNumber + " executed by " + threadName);
            });
        }

        // Shutdown the thread pool when it's no longer needed
        executorService.shutdown();
    }
}
