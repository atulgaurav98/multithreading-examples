public class RunnableExample {

    public static void main(String[] args) {
        // Create multiple threads using Runnable
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));

        // Start the threads
        thread1.start();
        thread2.start();
    }

    static class NumberPrinter implements Runnable {
        private final String threadName;

        public NumberPrinter(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + ": " + i);
            }
        }
    }
}
