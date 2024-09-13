import java.util.Scanner;

class Course {
    String code, name;

    /* Name of constructor is same as class name */
    Course() { // Non-parametrized
        code = "";
        name = "";
    }

    Course(String c, String n) { // Parametrized construictor
        code = c;
        name = n;
    }

    String getCourse() { // get accessor method
        return (code + " | " + name);
    }

    void setCourse(String c, String n) { // set accessor method
        code = c;
        name = n;
    }
}

public class CourseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code, name;

        // Populate course 1 details
        code = sc.nextLine(); // Input course code
        name = sc.nextLine(); // Input course name
        Course c1 = new Course(code, name); // Parameterised constructor

        // Populate course 2 details
        code = sc.nextLine(); // Input course code
        name = sc.nextLine(); // Input course name

        Course c2 = new Course(); // Non-parameterised constructor
        c2.setCourse(code, name);

        // Display course details
        System.out.printf("Courses:\n%s\n%s\n", c1.getCourse(), c2.getCourse());
    }
}

// Consider a sample run:

// Input:
// ES-CS201
// Programming for Problem Solving
// PCC-CS503
// Object Oriented Programming

// Output:
// Courses:
// ES-CS201 | Programming for Problem Solving
// PCC-CS503 | Object Oriented Programming