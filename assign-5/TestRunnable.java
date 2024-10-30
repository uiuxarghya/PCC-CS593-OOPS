// Observe the following program carefully which is expected to create thread and compute factorial:

import java.util.Scanner;

class MyThread implements Runnable {

  private String name;
  private int number;

  public MyThread(String name, int number) {
    this.name = name;
    this.number = number;
  }

  @Override
  public void run() {
    System.out.println(name + " Thread: Started");
    if (number < 0) {
      System.out.println(name + " Thread: ERROR");
    } else {
      long factorial = 1;
      for (int i = 1; i <= number; i++) {
        factorial *= i;
      }
      System.out.println(name + " Thread: " + factorial);
    }
    System.out.println(name + " Thread: Ended");
  }
}

public class TestRunnable {
  public static void main(String[] args) {
    System.out.println("Main Thread: Started");

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    MyThread mt1 = new MyThread("Factorial", n); // Construct a runnable object

    Thread nt1 = new Thread(mt1); // Construct a thread on that object
    nt1.start(); // Start running the thread
    System.out.println("Main Thread: Ended");

    sc.close();
  }
}

// For example:

// Input Result

// 4
// Main Thread: Started
// Main Thread: Ended
// Factorial Thread: Started
// Factorial Thread: 24
// Factorial Thread: Ended

// Correct

// -3
// Main Thread: Started
// Main Thread: Ended
// Factorial Thread: Started
// Factorial Thread: ERROR
// Factorial Thread: Ended

// Correct
