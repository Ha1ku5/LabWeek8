import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class Lab8b here.
 *
 * @author Alexander Leatha
 * @version 11/18/2022
 */
public class Lab8b {
    public static void main(String[] args) {
        // Test random matrix of integers
        int[][] a = randomMatrix (7, 20, 100);
        // use the above array to test next rowSum()
        int rowTotal = rowSum( a, 3);
        System.out.println("\n Sum of row  = " + rowTotal);

        // use the above array to test next colSum()
        int columSum = colSum( a, 4);
        System.out.println("\n Sum of columns  = " + columSum);

        isSquare(a);

        int[][] nonsquare = { {1,2,3}, {4,5}, {6,7,8,9} };
        int[][] notlatin = { {2,1,3}, {2,3,1}, {3,1,2} };
        int[][] latin = { {1,2,3}, {2,3,1}, {3,1,2} };
        int[][] allneg = { {-10,-12,-3}, {-4,-5,-6,-8}, {-7,-8} };
        int[][] notSquare = { {10, 12, 3, 17}, { 4, 5, 16, 18}, { 7, 9, 10, 45} };
        int[][] perfectSquare = { {1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16}};

        // Your tests, here are 2 to start with
        isLatin(nonsquare);
        isSquare(perfectSquare);

    }

    // (a) int[][] random(int n, int start, int end) returns an N-by-N matrix of
    // random integers ranging from start to end;
    public static int[][] randomMatrix (int n, int start, int end) {
        // your code goes here
        
        return null; // modify this later
    }

    // Generates a new random integer between 0 and end when called to be used in part(a)
    public static int randomGenerator(int end, int start){
        // your code goes here
        
        return 0; // modify this later
    }

    // (b) int rowSum(int[][] a, int i) returns the sum of the elements in row i of the 2-D array a
    public static int rowSum(int[][] a, int i) {
        // your code goes here
        
        return 0; // modify this later
    }

    // (c) int colSum(int[][] a, int j) returns the sum of the elements in column j of the 2-D array a
    public static int colSum(int[][] a, int j) {
        // your code goes here
        
        return 0; // modify this later
    }

    // (d) boolean isSquare(int[][] a) returns true if the 2-D array a is square (i.e. the number of
    // rows and columns are the same)
    public static boolean isSquare(int[][] a) {
        // your code goes here
        
        return true; // modify this later
    }

    // (e) boolean isLatin(int[][] a) returns true if the 2-D array a is a Latin square
    // (i.e. an n-by-n matrix such that each row and each column contains the values
    // from 1 through n with no repeats)
    public static boolean isLatin(int[][] a) {
        // your code goes here
        
        return true; // modify this later
    }
}