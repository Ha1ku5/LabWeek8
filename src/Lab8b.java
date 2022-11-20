import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a description of class Lab8b here.
 *
 * @author Alexander Leatha
 * @version 11/18/2022
 */
public class Lab8b {
    public static void main(String[] args) {

        // Test random matrix of integers
        int[][] a = randomMatrix (5, 1, 10840);
        int[][] b = randomMatrix (7, 20, 1080);
        int[][] c = randomMatrix (67, 6, 190);
        int[][] d = randomMatrix (8, 80, 99);
        int[][] e = randomMatrix (55, 50, 78);
        // use the above array to test next rowSum()
        int rowTotal = rowSum( a, 3);
        System.out.println("\n Sum of row  = " + rowTotal);

        //use the above array to test next colSum()
        int columSum = colSum( a, 4);
        System.out.println("\n Sum of columns  = " + columSum);

        int[][] nonsquare = { {1,2,3}, {4,5}, {6,7,8,9} };
        int[][] notlatin = { {2,1,3}, {2,3,1}, {3,1,2} };
        int[][] latin = { {1,2,3}, {2,3,1}, {3,1,2} };
        int[][] allneg = { {-10,-12,-3}, {-4,-5,-6,-8}, {-7,-8} };


        int[][] perfectSquare = { {1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16}};

        //so many tests
        System.out.println("\n row = " + rowSum( nonsquare, 2));
        System.out.println("\n row = " + rowSum( notlatin, 2));
        System.out.println("\n row = " + rowSum( latin, 2));
        System.out.println("\n row = " + rowSum( allneg, 2));

        System.out.println("\n col = " + colSum( nonsquare, 1));
        System.out.println("\n col = " + colSum( notlatin, 2));
        System.out.println("\n col = " + colSum( latin, 2));
        System.out.println("\n col = " + colSum( allneg, 1));

        System.out.println("\n isSquare(perfectSquare) = " + isSquare(perfectSquare));
        System.out.println("\n isSquare(nonSquare) = " + isSquare(nonsquare));
        System.out.println("\n isSquare(notLatin) = " + isSquare(notlatin));
        System.out.println("\n isSquare(latin) = " + isSquare(latin));

        System.out.println("\n isLatin(nonsquare) = " + isLatin(nonsquare));
        System.out.println("\n isLatin(notlatin) = " + isLatin(notlatin));
        System.out.println("\n isLatin(latin) = " + isLatin(latin));
        System.out.println("\n isLatin(allneg) = " + isLatin(allneg));

        test(a);
        test(b);
        test(c);
        test(d);


        //used to test efficiency of isLatin()
        //this array takes ~7 gigs of memory use caution
        /*
        int[][] hombreGrande = new int[20000][20000];
        for(int i = 0; i < hombreGrande.length; i++){
            for(int j = 0; j < hombreGrande.length; j++){
                hombreGrande[i][j] = Integer.parseInt(Integer.toString(i) + Integer.toString(j));
            }
        }
        System.out.println("START");
        System.out.println(isLatin(hombreGrande));
        */
    }

    //tests array on every method
    public static void test(int[][] test){
        System.out.println("\n rowSum(a, 3) = " + rowSum(test, 3));
        System.out.println("\n colSum(a, 4) = " + colSum(test, 4));
        System.out.println("\n isSquare(a) = " + isSquare(test));
        System.out.println("\n isLatin(a) = " + isLatin(test));
    }
    // (a) int[][] random(int n, int start, int end) returns an N-by-N matrix of
    // random integers ranging from start to end;
    public static int[][] randomMatrix (int n, int start, int end) {
        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++)
           for(int j = 0; j < arr[i].length; j++)
               arr[i][j] = randomGenerator(end, start);
        //System.out.println(Arrays.deepToString(arr));
        return arr; // modify this later
    }

    // Generates a new random integer between 0 and end when called to be used in part(a)
    public static int randomGenerator(int end, int start){
        return ((int)Math.floor(Math.random()*(end-start+1)+start));
    }

    // (b) int rowSum(int[][] a, int i) returns the sum of the elements in row i of the 2-D array a
    public static int rowSum(int[][] a, int i) {
        int sum = 0;
        for(int j : a[i])
            sum += j;
        return sum;
    }

    // (c) int colSum(int[][] a, int j) returns the sum of the elements in column j of the 2-D array a
    public static int colSum(int[][] a, int j) {
        int sum = 0;
        for(int[] i : a)
            sum += i[j];
        return sum;
    }

    // (d) boolean isSquare(int[][] a) returns true if the 2-D array a is square (i.e. the number of
    // rows and columns are the same)
    public static boolean isSquare(int[][] a) {
        for (int[] ints : a)
            if (ints.length != a.length)
                return false;
        return true;
    }

    // (e) boolean isLatin(int[][] a) returns true if the 2-D array is a Latin square
    //final version; took me forever, but it's pretty condensed and has only one for loop
    public static boolean isLatin(int[][] a) {
        if(!isSquare(a))
            return false;
        for(int i = 0; i < a.length; i ++) { //loops through for every row and column index
            int finalI = i;
            if (containsDuplicate(a[i])) //checks for dupes in current row
                return false;
            if(containsDuplicate(Arrays.stream(a).mapToInt //checks for dupes in current column
                    (ints -> ints[finalI]).toArray()))
                return false;
        }
        return true;
    }

    //puts array parameter elements into a hashset and checks its size against the arrays length
    //if they are equal, all the array elements are unique
    //for use in isLatin()
    public static boolean containsDuplicate(int[] a){
        Integer[] toCheck = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Set<Integer> checkAgainst = new HashSet<Integer>(Arrays.asList(toCheck));
        return !(checkAgainst.size() == toCheck.length);
    }

    //first iteration of isLatin()
    //multiple loops, creates extra arrays
    public static boolean isLatinOld(int[][] a) {
        if(!isSquare(a)) {
            System.out.println("non square");
            return false;
        }
        //checks array for duplicates in same row and column
        for (int[] row: a) //checks row uniqueness
            if (containsDuplicate(row)) {
                System.out.println("row dupe");
                return false;
            }
        for (int i = 0; i < a.length; i++){ //checks column uniqueness
            int[] testArr = new int[a.length];
            for (int j = 0; j < a.length; j++) {
                testArr[j] = a[j][i];
                //if(a[j][i] < 1 || a[j][i] > a.length)
                    //return false;
            }
            if(containsDuplicate(testArr)){
                System.out.println("col dupe");
                return false;
            }
        }
        return true;
    }


}
