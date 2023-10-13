package forkjoinframework;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class CustomTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int[] array;
    private int start;
    private int end;

    public CustomTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            CustomTask leftTask = new CustomTask(array, start, middle);
            CustomTask rightTask = new CustomTask(array, middle, end);

            // Fork left task and execute right task directly
            leftTask.fork();
            int rightResult = rightTask.compute();

            // Join the left task
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Using invoke() to submit the task and wait for its completion
        int result = pool.invoke(new CustomTask(array, 0, array.length));
        System.out.println("Result using invoke(): " + result);

        // Using submit() to submit the task without waiting for completion
        CustomTask task = new CustomTask(array, 0, array.length);
        pool.submit(task);

        // Join the submitted task
        int submittedResult = task.join();
        System.out.println("Result using submit() and join(): " + submittedResult);
    }
}
