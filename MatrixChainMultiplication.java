/**
 * Problem: Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * credit to GFG for the solution of O(n^2)
 * 
 * Example:
    Input: p[] = {40, 20, 30, 10, 30}   
    Output: 26000  
    There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
    Let the input 4 matrices be A, B, C and D.  The minimum number of 
    multiplications are obtained by putting parenthesis in following way
    (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

 * Proof:
 * https://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Dynamic/chainMatrixMult.htm
 * 
 * Time Complexity: O(n^3) on the normal algorithm, O(n^2) on the one below. 

 */
class MatrixChainMultiplication{
    static int MatrixChainOrder(int p[], int n)
    {
    
        /* For simplicity of the program, one extra row and one extra column are
        allocated in dp[][]. 0th row and 0th column of dp[][] are not used */
        int [][]dp=new int[n][n];
    
        /* dp[i, j] = Minimum number of scalar multiplications needed to compute the matrix M[i]M[i+1]...M[j]
                    = M[i..j] where dimension of M[i] is p[i-1] x p[i] */
                    
        // cost is zero when multiplying one matrix.
        for (int i=1; i<n; i++)
            dp[i][i] = 0;
    
        // Simply following above recursive formula.
        for (int L=1; L<n-1; L++)
            for (int i=1; i<n-L; i++)    
                dp[i][i+L] = Math.min(dp[i+1][i+L] + p[i-1]*p[i]*p[i+L],
                            dp[i][i+L-1] + p[i-1]*p[i+L-1]*p[i+L]);    
        
        return dp[1][n-1];
    }
    
    /*
    public static void main(String args[])
    {
        int arr[] = {10, 20, 30, 40, 30} ;
        int size = arr.length;
    
        System.out.print("Minimum number of multiplications is "+
                        MatrixChainOrder(arr, size));
    
    }
    */

}