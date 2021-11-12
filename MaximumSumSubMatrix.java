import java.util.Vector;

/**
 * Problem: Given a 2D array arr[][] of dimension N*M, the task is to find the maximum sum sub-matrix from the matrix arr[][]
 * Using Kadane's algorithm we can solve it efficiently in TC of O(n^3), unlike the naive approach which is O(n^6).
 * 
 * Example:
 * Input: arr[][] = {{ 0,-2, -7 , 0 },
 *                   { 9, 2, -6 , 2 },
 *                   {-4, 1, -4 , 1 },
 *                   {-1, 8,  0 ,-2 }}
 * Output: 15
 * Explanation: The submatrix {{9, 2},
 *                            {-4, 1},
 *                            {-1, 8}}
 * has a sum 15, which is the maximum sum possible.
 * 
 * 
 * 
 */
class MaximumSumSubMatrix{
    public static int kadane(Vector<Integer> arr, int n){
        int max_so_far = arr.get(0);
        int curr_max = arr.get(0);

        for (int i = 1; i < n; i++)
        {
            curr_max = Math.max(arr.get(i), curr_max+arr.get(i));
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    public static int maxSubMatrixSum(int[][] A){
        // Declare rows & cols
        int ROWS = A.length;
        int COLS = A[0].length;

        int[][] dpMatt = new int[ROWS][];

        // Walk all over the matrix and fill it with 0's - O(n^2)
        for (int i = 0 ; i < ROWS ; i++){
            dpMatt[i] = new int[ROWS];
            for (int j = 0 ; j < COLS ; j++ ){
                dpMatt[i][j] = 0;
            }
        }

        // Calculate rows of all matt A and store them in dpMatt - O(n^2)
        for (int i = 0 ; i < ROWS ; i++){
            for (int j = 0 ; j < COLS ; j++ ){
                if (j == 0) dpMatt[i][j] = A[i][j];
                else dpMatt[i][j] = A[i][j] + dpMatt[i][j-1];
            }
        }

        // Store the maximum submatrix sum
        int maxSum = Integer.MIN_VALUE;

        // traverse on cols - O(n^3)
        for ( int i = 0; i < COLS ; i++){

            // iterate for last col
            for (int j = i; j< COLS; j++){

                // store elements here
                Vector<Integer> v = new Vector<>();

                // walk over the ROWS 
                for ( int k = 0 ; k < ROWS; k++){

                    // current sum of rows
                    int curr_sum = 0;

                    // just like in kadane's, if the cell hasn't updated (0) add the current val in dpMatt to the cell, else substract
                    if (i == 0) curr_sum = dpMatt[k][j]; 
                    else curr_sum = dpMatt[k][j] - dpMatt[k][i-1];

                    v.add(curr_sum);
                    System.out.println("current sum " + curr_sum);
                }

            // compare between curr sum tand maxSum
            System.out.println("current sum " + maxSum);
            maxSum = Math.max(maxSum, kadane(v, v.size()));
            }
        }

        // return max sum
        return maxSum;
    }

    /*
    public static void main(String[] args) {
        // for kadane
        Vector<Integer> arr = new Vector<>();
        arr.add(-3);
        arr.add(1);
        arr.add(-2);
        arr.add(5);
        arr.add(0);
        arr.add(-8);
        arr.add(3);
         //{-3,1,-2,5,0,-8,3};

        // System.out.println(kadane(arr, arr.size()));
        
        int [][]matrix = { { 0, -2, -7, 0 },
                      { 9, 2, -6, 2 },
                      { -4, 1, -4, 1 },
                      { -1, 8, 0, -2 } };
 
    // Function Call
        System.out.println(maxSubMatrixSum(matrix));    
    }
    */
}