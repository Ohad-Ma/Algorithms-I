/**
 * Problem: 
 * Given two strings s1 and s2 return the length of the longest common subsequence of characters between the two strings
 * 
 * Example:
 * 
 * Input:
 * s1 = "ABCD"
 * s2 = "ABCD"
 * Output: 4
 * Explanation:
 * "ABCD"
 * "ABCD"
 * Both strings share the subsequence "A", "B", "C", "D".
 * 
 * TC: O(s1.length*s2.length)
 */
public class LongestCommonSubsequence {
    public static int LCS(String s1, String s2){
        // cols are + 1 to leave an empty room for empty string (AKA "")
        int rows = s2.length(),cols = s1.length()+1;

        // basic cases
        if (s1.equals(s2)) return s1.length();
        
        if (rows <= 0 || cols <= 0 ) throw new IllegalArgumentException("Invalid string");

        // sums will be stored here
        int[][] dpAns = new int[rows][cols];

    /*
    * dpAns[rows][cols] is our original subproblem. Each entry in the
    * table is taking a substring operation against whatever string is on the rows
    * or columns.
    * 
    * It goes from index 0 to index s2Row/s1Col (exclusive)
    * 
    * So if my s1 = "azb" and s1Col = 2...then my substring that I pass to the
    * lcs() function will be:
    * 
    * 0 1 2 "a  z  b"
    * 
    * "az" (index 2...our upper bound of the snippet...is excluded)
     */
        for (int s2Row = 0; s2Row <= rows; s2Row++) {
            for (int s1Col = 0; s1Col <= cols; s1Col++) {      
                if (s2Row == 0 || s1Col == 0) dpAns[s2Row][s1Col] = 0;
              
                else if (s2.charAt(s2Row - 1) == s1.charAt(s1Col - 1)) dpAns[s2Row][s1Col] = dpAns[s2Row - 1][s1Col - 1] + 1;
              
                else dpAns[s2Row][s1Col] = Math.max(dpAns[s2Row - 1][s1Col], dpAns[s2Row][s1Col - 1]);
            }
        }
        return dpAns[s2.length()][s1.length()];
    }

}
