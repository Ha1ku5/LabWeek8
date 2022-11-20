import java.util.Scanner;

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

        //fills the array with sequential numbers that shift to the right every row
        for (int row = 0; row < digits.length; row++)
            for (int col = 0; col < digits[row].length; col++)
                digits[row][col] = (row + col) % 10;

        //prints the array
        line(digits.length);
        for (int[] digit : digits) {
            for (int j = 0; j < digits.length; j++)
                System.out.print("| " + digit[j] + " ");
            System.out.println("|");
            line(digits.length);
        }
    }

    public static void line(int size){
        for(int i = 0; i < size; i++)
            System.out.print("+---");
        System.out.println("+");
    }
}
