import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] nums = new int[3][];
        for(int row = 0; row < nums.length; row++){
            nums[row] = new int[row + 1];
            for(int col = 0; col < nums[row].length; col++){
                nums[row][col] = row + col;
            }
        }

    }
}