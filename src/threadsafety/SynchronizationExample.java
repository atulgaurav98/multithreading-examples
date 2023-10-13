package threadsafety;

public class SynchronizationExample {

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create multiple threads
        Thread thread1 = new Thread(new IncrementTask(counter));
        Thread thread2 = new Thread(new IncrementTask(counter));
        Thread thread3 = new Thread(new IncrementTask(counter));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final Count: " + counter.getCount());
    }

    static class Counter {
        private int count;

        // Synchronize the increment method to ensure thread safety
        public synchronized void increment() {
            count++;
        }

        // synchronize using block syntax
        public void incrementUsingSyncBlock() {
            synchronized (this) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    static class IncrementTask implements Runnable {
        private Counter counter;

        public IncrementTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
                // counter.incrementUsingSyncBlock();
            }
        }
    }
}
