// Using built-in Java Stack class, write a Java program to develop a Generic stack of size 5, input choice and process as follows:

// 1: Push element

// 2: Pop element and display

// 0. Quit

// When stack capacity is 5, display [Full-5] after detecting stack full exception and display [Empty] after detecting stack empty exception. Testing of this Generic Stack will be done with String elements.

// For example:

// Input	Result
// 2
// 0
// [Empty]

import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;

// Declare public class SimpleStack with main() method
public class SimpleStack {

    public static void main(String[] args) {
        IGenSimpleStack<String> stack = new GenSimpleStack<>(5); // Stack of size 5
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    String element = sc.nextLine();
                    try {
                        stack.push(element);
                    } catch (StackFullException e) {
                        System.out.print("[Full-5] ");
                    }
                    break;

                case 2:
                    try {
                        String poppedElement = stack.pop();
                        System.out.print(poppedElement + " "); // Print popped element immediately
                    } catch (StackEmptyException e) {
                        System.out.print("[Empty] ");
                    }
                    break;

                case 0:
                    break; // Exit the loop
            }

        } while (choice != 0);

        sc.close();
    }
}

// Declare interface IGenSimpleStack<T>
interface IGenSimpleStack<T> {
    void push(T item) throws StackFullException;

    T pop() throws StackEmptyException;
}

// Declare GenSimpleStack<T> implementing interface IGenSimpleStack
class GenSimpleStack<T> implements IGenSimpleStack<T> {
    private Stack<T> stack;
    private int capacity;

    public GenSimpleStack(int capacity) {
        this.stack = new Stack<>();
        this.capacity = capacity;
    }

    @Override
    public void push(T item) throws StackFullException {
        if (stack.size() == capacity) {
            throw new StackFullException("Stack is full");
        }
        stack.push(item);
    }

    @Override
    public T pop() throws StackEmptyException {
        try {
            return stack.pop();
        } catch (EmptyStackException e) {
            throw new StackEmptyException("Stack is empty");
        }
    }
}

// Declare StackFullException class
class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
}

// Declare StackEmptyException class
class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

// Output

// 2 0[Empty][Empty]Correct Correct 1 Tom 1 Jerry 2 2 0

// Jerry Tom
// Jerry Tom
// Correct Correct 1 Tom 1 Jerry 2 2 2 0 Jerry Tom[Empty]Jerry Tom[Empty]
// Correct Correct 1 100 1 200 2 2 0 200 100 200 100
// Correct Correct 1 Tom 2 0
// Tom Tom
// Correct Correct 1 Tom 1 Jerry 1 Spike 1 Tyke 1 Toodle 1 Nibbles 2 2
// 0[Full-5]Toodle Tyke[Full-5]
// Toodle Tyke