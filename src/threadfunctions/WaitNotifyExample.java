package threadfunctions;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waiterThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiter is waiting...");
                    lock.wait(); // Thread waits until notified
                    System.out.println("Waiter is awakened.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifierThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Notifying waiter...");
                    lock.notify(); // Notifying the waiting thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        waiterThread.start();
        notifierThread.start();
    }
}
