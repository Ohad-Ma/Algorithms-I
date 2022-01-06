/**
 * Problem: Two teams A and B play to see who is the first to win 
 * n games. In world series games n=4. 
 * 
 * - Team A wins any particular game with probability q (same for all the games).
 * - What is the probability of A winning the tournament?
 * 
 * TC: O(n*m)
 */
public class WorldSeriesOdds {
    public static double[][] winningRate(int n, int m){
        double q = 0.5;
        double[][] ans = new double[n][m];
        for (int i = 1; i<n; i++){
            ans[0][i] = 1;
        }
        for (int j = 1; j<m; j++){
            ans[j][0] = 0;
        }

        for (int i = 1; i < n ; i++){
            for (int j = 1; j < m ; j++)
                ans[i][j] = (q)*ans[i-1][j] + (1-q)*ans[i][j-1];
        }
        return ans;
    }
    
    /**
     * Print matrix
    public static void main(String[] args) {
        int n = 5, m = 5;
        double[][] mat = winningRate(n, m);
        for (int i = 0; i < n; i++){
            System.out.println();
            for (int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
        }
    }
     */
}
