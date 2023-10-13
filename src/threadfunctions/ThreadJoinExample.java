package threadfunctions;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            // Wait for thread1 to complete
            // i.e calling thread (main thread) will wait for the thread to join back then
            // only it will proceed
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 has completed.");

        // Now, let's wait for thread2 to complete
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 2 has completed.");
    }
}
