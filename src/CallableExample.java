import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        // Create a thread pool with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a Callable task and receive a Future object
        Future<Integer> future = executor.submit(new Calculator());

        try {
            // Retrieve the result from the Future object
            int result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }

    static class Calculator implements Callable<Integer> {
        @Override
        public Integer call() {
            // Perform a simple calculation
            int result = 0;
            for (int i = 1; i <= 5; i++) {
                result += i;
            }
            return result;
        }
    }
}
