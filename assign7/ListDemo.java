// Study the partial program carefully which is responsible for inputting a few numbers, populate an array list, sort in descending order and perform binary search in the sorted list for the entered key.
// Hints: Use Iterator Design pattern

import java.util.*;

public class ListDemo {
	// Populate list from the input
	static void populateList(Scanner sc, ArrayList<Integer> al) {
		// Input line from keyboard
		String inputLine = sc.nextLine();

		// Create scanner object for the line
		Scanner lineScanner = new Scanner(inputLine);

		// Grab number and add to array list
		while (lineScanner.hasNextInt()) {
			al.add(lineScanner.nextInt());
		}

		// Close the scanner
		lineScanner.close();
	}

	// Display the list with a title
	static void displayList(String title, ArrayList<Integer> al) {
		// Obtain an Iterator
		Iterator<Integer> iterator = al.iterator();

		// Display title
		System.out.print(title + ": ");

		// Check whether next element exists and display
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

	// Sort the list in descending order
	static void sortListDesc(ArrayList<Integer> al) {
		// Sort using reverseOrder
		Collections.sort(al, Collections.reverseOrder());
	}

	// Perform binary search for the key in descending order list
	static int binSearch(ArrayList<Integer> al, int key) {
		int index = Collections.binarySearch(al, key, Collections.reverseOrder());
		return index;
	}

	public static void main(String[] args) {
		int key, index;

		// Create Scanner objects
		Scanner sc = new Scanner(System.in); // Handle inputs

		// Create a list of Integers
		ArrayList<Integer> al = new ArrayList<Integer>();

		// Enter few numbers in a line and populate the list
		populateList(sc, al);

		// Display list
		displayList("Original List", al);

		// Sort list in descending order
		sortListDesc(al);

		// Display sorted list
		displayList("Sorted List", al);

		// Input key
		key = sc.nextInt();

		// Perform binary search for key in al
		index = binSearch(al, key);
		if (index >= 0)
			System.out.println("Position: " + index);
		else
			System.out.println("Not found");

		// Cleanup
		sc.close();
	}
}


// 45 23 67 12
// 23
// Original List: 45 23 67 12
// Sorted List: 67 45 23 12
// Position: 2
// Original List: 45 23 67 12
// Sorted List: 67 45 23 12
// Position: 2
// Correct

// Correct
// 89 45 23 67 12 79
// 67
// Original List: 89 45 23 67 12 79
// Sorted List: 89 79 67 45 23 12
// Position: 2
// Original List: 89 45 23 67 12 79
// Sorted List: 89 79 67 45 23 12
// Position: 2