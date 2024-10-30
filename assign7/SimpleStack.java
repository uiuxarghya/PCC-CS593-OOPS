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

// Import necessary libraries
import java.util.Scanner;

// Interface declaration for Generic Stack
interface IGenSimpleStack<T> {
  void push(T element) throws StackFullException;

  T pop() throws StackEmptyException;
}

// Class implementing the Generic Stack
class GenSimpleStack<T> implements IGenSimpleStack<T> {
  private T[] stack;
  private int top;
  private int capacity;

  // Constructor to initialize the stack
  @SuppressWarnings("unchecked")
  public GenSimpleStack(int size) {
    this.capacity = size;
    this.stack = (T[]) new Object[size];
    this.top = -1; // Top is initialized to -1 to indicate an empty stack
  }

  // Push method to add element to the stack
  @Override
  public void push(T element) throws StackFullException {
    if (top == capacity - 1) { // If top is at the last position, stack is full
      throw new StackFullException("Stack is full.");
    }
    stack[++top] = element;
  }

  // Pop method to remove and return the top element of the stack
  @Override
  public T pop() throws StackEmptyException {
    if (top == -1) { // If top is -1, stack is empty
      throw new StackEmptyException("Stack is empty.");
    }
    return stack[top--];
  }
}

// Custom exception for Stack Full
class StackFullException extends Exception {
  public StackFullException(String message) {
    super(message);
  }
}

// Custom exception for Stack Empty
class StackEmptyException extends Exception {
  public StackEmptyException(String message) {
    super(message);
  }
}

// Main class
public class SimpleStack {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GenSimpleStack<String> stack = new GenSimpleStack<>(5); // Create a stack of size 5
    while (true) {
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          // Push element
          String element = scanner.nextLine();
          try {
            stack.push(element);
          } catch (StackFullException e) {
            System.out.print("[Full-5] ");
          }
          break;

        case 2:
          // Pop element
          try {
            String poppedElement = stack.pop();
            System.out.print(poppedElement + " ");
          } catch (StackEmptyException e) {
            System.out.println("[Empty]");
          }
          break;

        case 0:
          // Quit
          scanner.close();
          return;

        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }
}

// 2
// 0
// [Empty]
// [Empty]
// Correct
// Correct
// 1
// Tom
// 1
// Jerry
// 2
// 2
// 0
// Jerry Tom
// Jerry Tom
// Correct
// Correct
// 1
// Tom
// 1
// Jerry
// 2
// 2
// 2
// 0
// Jerry Tom [Empty]
// Jerry Tom [Empty]
// Correct
// Correct
// 1
// 100
// 1
// 200
// 2
// 2
// 0
// 200 100
// 200 100
// Correct
// Correct
// 1
// Tom
// 2
// 0
// Tom
// Tom
// Correct
// Correct
// 1
// Tom
// 1
// Jerry
// 1
// Spike
// 1
// Tyke
// 1
// Toodle
// 1
// Nibbles
// 2
// 2
// 0
// [Full-5] Toodle Tyke
// [Full-5] Toodle Tyke