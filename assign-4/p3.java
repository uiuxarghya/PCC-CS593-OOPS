import java.util.*;

public class TestExc {
    public static void main(String args[]) {
        int num = 0, sum = 0;
        Scanner sc = new Scanner(System.in);

        try {
            num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        } catch (InputMismatchException e) {
            System.out.println("ERROR");
        }

        sc.close();
    }
}