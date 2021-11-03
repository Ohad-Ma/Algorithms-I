/**
 * The Problem 
 * Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). 
 * For example, your function should return 6 for n = 4 and k = 2,
 * and it should return 10 for n = 5 and k = 2.
 * 
 * Time Complexity: O(n*k)
 * Solution using Dynamic Programming & pascal triangle
 */
public class BinominalCoefficients {
    public static int binominalCoefficient(int n, int k)
    {
        if (n<0 || k<0) throw new IllegalArgumentException("Invalid parameters");

        int choose[] = new int[k+1];
        // k = 0 -> return 1
        choose[0] = 1;

        // index 0 exists
        for (int i = 1; i <= n; i++){
            // next row of pascal using the previous one
            for (int j = Math.min(i, k); j > 0; j--) choose[j] = choose[j] + choose[j-1]; 
        }
        return choose[k];

    }
}
