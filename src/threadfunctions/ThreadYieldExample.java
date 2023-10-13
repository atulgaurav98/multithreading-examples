package threadfunctions;

public class ThreadYieldExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new WorkerThread("Thread 1"));
        Thread thread2 = new Thread(new WorkerThread("Thread 2"));

        thread1.start();
        thread2.start();
    }

    static class WorkerThread implements Runnable {
        private String name;

        public WorkerThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " is working on task " + i);
                if (i == 2) {
                    System.out.println(name + " is yielding.");
                    Thread.yield(); // Yield the CPU
                }
            }
        }
    }
}
