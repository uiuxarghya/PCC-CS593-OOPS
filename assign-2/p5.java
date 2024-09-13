
class Parent {
  public void home() {
    System.out.println("Existing home");
  }

  public void car() {
    System.out.println("Existing car");
  }
}

/*
 * Method overriding allows a subclass to provide a specific implementation of a
 * method that is already provided by its parent class. In this example, car()
 * method in the Child class overrides the car() definition in the parent.
 */

// Declare Child class
class Child extends Parent {

  /* Optional annotation */
  @Override
  // Declare car() method
  public void car() {
    // Display "New car"
    System.out.println("New car");
  }
}

public class TestOverride {
  public static void main(String[] args) {
    Child c1 = new Child();
    c1.home();
    c1.car();
  }
}
