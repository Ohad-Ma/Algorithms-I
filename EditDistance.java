/**
 * Problem:
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  
 * 1) Insert
 * 2) Remove
 * 3) Replace
 * 
 * All of the above operations are of equal cost. 
 * 
 * Solution:
 * By time complexity of O(s1.length * s2.length) we can solve this algorithm using Dynamic Programming
 * 1) we make a dp table[s1.length+1][s2.length+1]
 * 2) we fill first row and col with increasing index
 * 3) using two for loops in range of 1 to length of both strings we ask:
 *      * if -> chars are equals put the value of the cell [i-1][j-1]
 *      * else -> value is minimum value between [i-1][j], [i][j-1], [i-1][j-1] + 1
 * 4) return the dpTable[row][col] (the answer is at the last cell)
 * 
 * 
 * Example:
 * s1 = "ohad" s2 = "omedm"
 * 
 *  *"omedm"/"ohad" --> 
 *  |
 *  v
 *    ""  o    h    a    d
 * "" 0   1    2    3    4  
 *        ________________
 * o  1  |0    1    2    3 
 * m  2  |1    1    2    3
 * e  3  |2    2    2    3
 * d  4  |3    3    3    2
 * m  5  |4    4    4    3
 * 
 * (1,1) - 'o' exists therefore, put the value in cell [0][0] (0) inside (1,1), 
 * (1,2) - 'o' != 'h' therefore, take the minimum between (1,1),(0,1),(0,2) and add + 1 -> min(0,1,2) = 0, 0 + 1 = 1. Then the value in (1,2) is 1.
 * 
 * -------------------
 * (1,1),(0,1),(0,2) = 
 *      o   h
 *      1   2
 *      _____
 * o 1| 0   1     
 * h 2| 1   ?
 * 
 * 
 */
class EditDistance{
    public static int editDistance(String s1,String s2){
        // row & cols of dp table
        int row = s1.length(),col = s2.length();
        
        // dp table 
        // *+1 is for the whole range of numbers included*
        int[][] dpTable = new int[row+1][col+1];

        // fill rows and cols with numbers
        for(int i = 0; i<= row; i++) dpTable[i][0] = i;
        for(int i = 0; i <= col; i++) dpTable[0][i] = i;

        for(int i = 1; i<=row; i++){
            for(int j = 1; j<=col; j++){
                // if 'a' == 'a' just put the minimum in the value of the table
                if(s1.charAt(i-1) == (s2.charAt(j-1))) dpTable[i][j] = dpTable[i-1][j-1];
                
                // else value is minimum value between [i-1][j], [i][j-1], [i-1][j-1] + 1
                else  
                    dpTable[i][j] = Math.min(dpTable[i-1][j-1], Math.min(dpTable[i-1][j], dpTable[i][j-1])) + 1;  
            }
        }
        // at the end of the DP table we have our answer
        return dpTable[row][col];
    }

    /*
    public static void main(String[] args) {
        String s1 = "ohad",s2 = "omedm";

        System.out.println(editDistance(s1,s2));
    }
    */
}