import java.util.Scanner;
import java.util.*;

/**
 * Write a description of class ShiftNumbers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

// Write a program that takes an integer n as the number of both rows and columns for your 2D array.
// Create a 2D array as displayed in Lab handout.
public class ShiftNumbers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer, then press Enter");
        int n = keyboard.nextInt();

        // Creates an array of int arrays
        int[][] digits = new int[n][n];

        // TODO: Fill the 2D array with numbers
        

        // TODO: Print the array
        

        // Prints the lower border
        for(int j = 0; j < digits[0].length; ++j) {
            System.out.print("+-");
        }
        System.out.println("+");
    }
}
