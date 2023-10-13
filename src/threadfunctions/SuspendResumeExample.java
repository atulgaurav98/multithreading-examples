package threadfunctions;

public class SuspendResumeExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            Thread.sleep(2000);
            thread.suspend(); // Deprecated method to suspend the thread
            System.out.println("Thread is suspended.");
            Thread.sleep(2000);
            thread.resume(); // Deprecated method to resume the thread
            System.out.println("Thread is resumed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
