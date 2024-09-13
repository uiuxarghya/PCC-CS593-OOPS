import java.util.Scanner;

public class Hello {
    public static void main(String args[]) {
        /* Create Scanner object for reading from keyboard */
        Scanner sc = new Scanner(System.in);

        /* Use nextLine() for string input and nextInt() for integer input */
        String name = sc.nextLine();

        /* Use + operator for concatenation */
        System.out.println("Hello " + name + "!");

        /* Close the Scanner object */
        sc.close();
    }
}