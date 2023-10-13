package threadsafety;

public class FinalExample {

    // Initializing a string
    // variable of final type
    final String str = new String("hello");

    // Defining a method to
    // change the value of the final
    // variable which is not possible,
    // hence the error will be shown
    void method() {
        // str = "world";
    }
}
