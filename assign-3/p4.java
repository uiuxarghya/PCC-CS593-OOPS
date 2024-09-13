// Write a Java program to evaluate a simple postfix expression where operators and operands are separated by space characters. As for handling postfix expressions, you need a stack and implement it by array handling.

// Following methods may be useful for string processing:

// exp = sc.nextLine(): read line from the scanner object sc into exp string

// exp.split(" "): return space separated words or tokens into an array of strings

// Avoid displaying extra characters or input / output prompts while taking input or displaying output, which are otherwise needed for an interactive program.

import java.util.*;

/* Declare Stack class */
class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Stack is initially empty
    }

    // isEmpty Method
    public boolean isEmpty() {
        return (top == -1);
    }

    // isFull Method
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // push method
    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full, cannot push " + value);
        }
    }

    // pop method
    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty, cannot pop");
            return -1; // Return an invalid value
        }
    }
}

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String exp[] = in.split(" ");

        // Create a Stack instance
        Stack stack = new Stack(exp.length);

        for (int i = 0; i < exp.length; i++) {
            String ch = exp[i];
            switch (ch) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n = stack.pop();
                    stack.push(stack.pop() - n);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n = stack.pop();
                    stack.push(stack.pop() / n);
                    break;
                default:
                    // Push the number onto the stack
                    stack.push(Integer.parseInt(ch));
            }
        }
        // The result will be the only item left on the stack
        System.out.println(stack.pop());
    }
}