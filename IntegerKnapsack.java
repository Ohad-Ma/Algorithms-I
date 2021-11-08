/**
 * Problem:
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 *  Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 *  - You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * 
 * geeksforgeeks: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * Time Complexity: O(N*W). 
 * where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
 * 
 * 
 * TODO: Understand the code to the max
 */
public class IntegerKnapsack {
 
    // Returns the value of maximum profit  
    static int knapSackRec(int W, int wt[],int val[], int n,int [][]dp)
    {  
        
        // Base condition
        if (n == 0 || W == 0)  
            return 0;
            
        if (dp[n][W] != -1)
            return dp[n][W];  
        
        if (wt[n - 1] > W)  
            // Store the value of function call  
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val,n - 1, dp);                              
        else
            // Return value of table after storing 
            return dp[n][W] = Math.max((val[n - 1] + knapSackRec(W - wt[n - 1], wt,val, n - 1, dp)),knapSackRec(W, wt, val, n - 1, dp));            
    }
    
    static int knapSack(int W, int wt[], int val[], int N)
    { 
        
        // Declare the table dynamically
        int dp[][] = new int[N + 1][W + 1];
        
        // Loop to initially filled the
        // table with -1
        for(int i = 0; i < N + 1; i++)  
            for(int j = 0; j < W + 1; j++)  
                dp[i][j] = -1;   
        
        return knapSackRec(W, wt, val, N, dp);    
    }
    

/*
public static void main(String [] args)
{      
    int val[] = { 60, 100, 120 };  
    int wt[] = { 10, 20, 30 };  
     
    int W = 50; 
    int N = val.length;        
     
    System.out.println(knapSack(W, wt, val, N));  
}    
*/
}
