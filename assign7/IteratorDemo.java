

import java.util.*;

public class IteratorDemo {
	public static void main(String[] args) {
		/* Create list */
		ArrayList<Integer> al = new ArrayList<Integer>();

		/* Add entries */
		al.add(50);
		al.add(10);
		al.add(30);
		al.add(60);
		al.add(20);
		System.out.println("Original List> Size: " + al.size());
		System.out.println("Original List> " + al);

		/* Sort list */
		al.sort(Comparator.naturalOrder()); /* Method 1: Sort arraylist */
		System.out.println("Ascending List> " + al);

		al.sort(Comparator.reverseOrder()); /* Method 1: Sort arraylist */
		System.out.println("Descending List> " + al);

		/* Iterate thru the list */
		Iterator<Integer> itr = al.iterator(); /* Obtain an iterator */

		int n;
		System.out.println("Iterate using Iterator");
		while (itr.hasNext()) {
			n = itr.next();
			System.out.println(n);
		}

		System.out.println("Iterate using enhanced-for");
		for (int x : al) /* Iterate using traditional enhanced-for */
			System.out.println(x + " ");
	}
}