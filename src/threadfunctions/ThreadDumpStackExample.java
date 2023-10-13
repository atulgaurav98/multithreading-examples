package threadfunctions;

public class ThreadDumpStackExample {

    public static void main(String[] args) {
        System.out.println("Main thread is running.");

        Thread.dumpStack();

        System.out.println("Main thread finished.");
    }
}
