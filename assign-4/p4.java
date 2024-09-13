import java.util.*;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class TestException2 {
    public static void main(String[] args) {
        try {
            int num = 10; /* Assign positive or negative number */
            if (num < 0) {
                throw new MyException("Number cannot be negative");
            }
            System.out.println("Number is positive: " + num);
        } catch (MyException e) {
            System.out.println("Caught a custom exception: " + e.getMessage());
        }
    }
}