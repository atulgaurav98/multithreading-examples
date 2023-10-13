package threadfunctions;

public class ThreadSleepExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Countdown: " + i);
            try {
                Thread.sleep(1000); // Pause the current thread for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}