
// The following program is internally stored and can be executed after you supply the missing part in the answer window. This is intended for adding numbers within a large list using multiple threads and display sum totals from both threads as given in the following example:
import java.util.Scanner;

class MyThread implements Runnable {

	Thread thrd;
	int result;
	int[] list;

	/* MyThread Constructor */

	MyThread(String name, int[] nums) {
		thrd = new Thread(this, name);
		list = nums;
		thrd.start(); // Start thread
	}

	/* ********************************* */

	public void run() {
		result = 0;
		for (int i : list) {
			result += i;
		}
	}

	/* ********************************* */

	public int getSum() {
		return (result);
	}
}

public class Test {
	public static void main(String[] args) {

		int[] arr = new int[10];
		int i = 0;

		/* Populate array */
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt())
			arr[i++] = sc.nextInt();

		/* Create threads */
		MyThread mt1 = new MyThread("C1", arr);
		MyThread mt2 = new MyThread("C2", arr);

		try {
			mt1.thrd.join();
			mt2.thrd.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted");
		}

		System.out.println(mt1.thrd.getName() + ": " + mt1.getSum());
		System.out.println(mt2.thrd.getName() + ": " + mt2.getSum());

		sc.close();
	}

}

// Test Case

// | Input | Expected Output | Got Output | Status |
// | 13 7 9 11 33 | C1:73 C2:73 | C1:73 C2:73 | Pass |
