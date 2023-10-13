package threadfunctions;

public class ThreadGetSetExample {
    public static void main(String[] args) {
        Thread thread = new Thread("Thread 1");
        System.out.println("Hi! I am " + thread.getName());
        thread.setName("Thread 2");
        System.out.println("Hi! I am " + thread.getName());
    }
}
