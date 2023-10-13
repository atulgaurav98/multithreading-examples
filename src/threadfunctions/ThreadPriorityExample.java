package threadfunctions;

public class ThreadPriorityExample {

    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(new WorkerThread("High Priority Thread"));
        Thread lowPriorityThread = new Thread(new WorkerThread("Low Priority Thread"));

        highPriorityThread.setPriority(Thread.MAX_PRIORITY); // Highest priority
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY); // Lowest priority

        highPriorityThread.start();
        lowPriorityThread.start();

        try {
            highPriorityThread.join();
            lowPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class WorkerThread implements Runnable {
        private String name;

        public WorkerThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis(); // Record start time
            long sum = 0;
            for (long i = 0; i < 10000000L; i++) {
                sum += i;
            }
            long endTime = System.currentTimeMillis(); // Record end time
            System.out.println(name + " completed its work in " + (endTime - startTime) + " ms");

        }
    }
}
