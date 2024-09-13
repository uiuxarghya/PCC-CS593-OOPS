import java.util.*;

public class Find {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i = 0, size;
        double result;
        int nums[] = new int[50];

        int key = sc.nextInt();
        while (sc.hasNextInt())
            nums[i++] = sc.nextInt();

        if (find(key, nums))
            System.out.println("Found");
        else
            System.out.println("Missing");

    } /* end of main */

    /* Need static method declaration as it is called from static main() method */

    static boolean find(int key, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return true;
        }
        return false;
    }
}