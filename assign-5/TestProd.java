import java.util.Scanner;

class MyThread implements Runnable {

  Thread thrd;
  int result;
  int[] list;

  /* MyThread Constructor */

  MyThread(String name, int[] nums) {
    thrd = new Thread(this, name);
    list = nums;
    result = 1; // Initialize result to 1 for multiplication
    thrd.start(); // Start thread
  }

  /* ********************************* */

  public void run() {
    for (int i : list) {
      result *= i;
    }
  }

  /* ********************************* */

  public int getProduct() {
    return result;
  }
}

public class TestProd {
  public static void main(String[] args) {

    int[] arr = new int[10];
    int i = 0;

    /* Populate array */
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt())
      arr[i++] = sc.nextInt();

    /* Create threads */
    MyThread mt1 = new MyThread("P1", arr);
    MyThread mt2 = new MyThread("P2", arr);

    try {
      mt1.thrd.join();
      mt2.thrd.join();
    } catch (InterruptedException exc) {
      System.out.println("Main thread interrupted");
    }

    System.out.println(mt1.thrd.getName() + ": " + mt1.getProduct());
    System.out.println(mt2.thrd.getName() + ": " + mt2.getProduct());

    sc.close();
  }
}

// Test Case
// | Input | Expected Output | Got Output | Status |
// | 2 3 4 | P1: 24 P2: 24 | P1: 24 P2: 24 | Pass |
