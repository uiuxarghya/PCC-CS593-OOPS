// Write a Java program to input a few numbers, sort those and display maintaining 2 decimal places. Ensure to take inputs only when a number is existing in the input stream. Avoid displaying extra characters or input / output prompts while taking input or displaying output.

// Input	
// 21 10 5.7

// Result
// 5.70 10.00 21.00

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int i=0, size;
        
        // initialize nums array of 
        double nums[] = new double[50];

    	while ( sc.hasNextDouble() )
            nums[i++] = sc.nextDouble();

        size = i;
        
        /* You may use Arrays.sort() or your own sorting code */
        Arrays.sort(nums, 0, size);

        /* Display array elements with 2 decimal places using printf(); 
           used in earlier assignments */
        for(i=0;i<size;i++){
            System.out.printf("%.2f ",nums[i]);
        }
    }
}
