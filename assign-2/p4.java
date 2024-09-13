import java.util.Scanner;

/* Method overloading feature allows a class to have more than one method with the same name, provided that the parameter list is different. 

In this example, method overloading is applied for square() method. If main() calls square() with int parameter, square(int) method will be triggreed, whereas square(double) will be triggered when square() called with double parameter. */

/* Declare class MethodOverload */
class MethodOverload {
    // Declare square method for returning area in integer
    int square(int n) {
        return n * n;
    }

    // Declare square method for returning area in double
    double square(double n) {
        return n * n;
    }
}

public class MethodOverloadTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inputs
        int n = sc.nextInt();
        double d = sc.nextDouble();

        // Instantiate MethodOverload class for using square methods
        MethodOverload mol = new MethodOverload();

        // Call square method
        System.out.printf("Square of %d: %d\n", n, mol.square(n));

        // Call overloaded square method
        // BTW, overloading also possible with different number or order of parameters
        System.out.printf("Square of %f: %.2f\n", d, mol.square(d)); // Overloaded method
    }
}
