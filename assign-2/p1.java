import java.util.Scanner;

class Rectangle {
    double length;   // Specify data type
    double breadth;

    Rectangle(double l, double b){     // Constructor
        length = l;
        breadth = b;
    }
    
    double computeArea() {             // Copute Area Method
        return(length * breadth);
    }
}

public class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
       
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        
        Rectangle r1 = new Rectangle( a, b );    //  Parameterized constructor used  for object creation
        System.out.println( r1.computeArea() );

    }
}

