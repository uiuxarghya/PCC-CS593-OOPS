import java.util.Scanner;

// Superclass Shape
class Shape {
  double area;

  void computeArea() {
    System.out.println("Compute area based on specific shape");
  };

  void displayShape() {
    System.out.println("Display Shape dimensions with area");
  };
}

// Subclass Circle
class Circle extends Shape {
  double r;

  Circle(double r) {
    this.r = r;
  }

  @Override
  void computeArea() {
    super.area = Math.PI * r * r;
  }

  @Override
  void displayShape() {
    System.out.printf("Circle(%.2f) Area: %.2f\n", r, super.area);
  }
}

// Subclass Rectangle
class Rectangle extends Shape {
  double l, b;

  Rectangle(double l, double b) {
    this.l = l;
    this.b = b;
  }

  @Override
  void computeArea() {
    super.area = l * b;
  }

  @Override
  void displayShape() {
    System.out.printf("Rectangle(%.2f,%.2f) Area: %.2f\n", l, b, super.area);
  }
}

// Subclass Triangle
class Triangle extends Shape {
  double h, b;

  Triangle(double h, double b) {
    this.h = h;
    this.b = b;
  }

  @Override
  void computeArea() {
    super.area = 0.5 * h * b;
  }

  @Override
  void displayShape() {
    System.out.printf("Triangle(%.2f,%.2f) Area: %.2f\n", h, b, super.area);
  }
}

// Main class
public class Sheets {

  // Declare createShape method
  // static as it is called from static main method
  static Shape createShape(int type, Scanner sin) {
    Shape obj;

    // Create specific shape object based on type value
    // 1: Circle
    // 2: Rectangle
    // 3: Triangle

    switch (type) {
      case 1: // Circle
        // Display "Circle detected"
        System.out.println("Circle detected");

        // Create Circle object
        obj = new Circle(sin.nextDouble());
        obj.computeArea();
        break;

      case 2: // Rectangle
        // Display "Rectangle detected"
        System.out.println("Rectangle detected");

        obj = new Rectangle(sin.nextDouble(), sin.nextDouble());
        obj.computeArea();
        break;

      case 3: // Triangle
        // Display "Triangle detected"
        System.out.println("Triangle detected");

        obj = new Triangle(sin.nextDouble(), sin.nextDouble());
        obj.computeArea();
        break;

      default:
        System.out.printf("Ignoring wrong type: %d\n", type);
        // Set obj to null
        obj = null;
        break;
    }

    return obj;
  }

  // main method
  public static void main(String args[]) {
    Shape Shapes[] = new Shape[50];
    int n, i = 0, sheetType;
    Shape s;

    Scanner sc = new Scanner(System.in);

    // Loop inputs taking as long as Ctrl-d is not pressed
    while (sc.hasNextInt()) {
      // Input sheet type (1: Circle, 2: Rectangle, 3: Traiangle)
      sheetType = sc.nextInt();
      s = createShape(sheetType, sc); // Create Shape object
      if (s != null)
        Shapes[i++] = s; // Populate into Shapes array
    }

    n = i - 1; // No. of sheets

    for (i = 0; i <= n; i++) {
      System.out.print(i + ": ");
      Shapes[i].displayShape();
    }

  }
}
