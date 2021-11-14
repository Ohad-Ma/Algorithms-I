/**
 * Problem: Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
 * 
 * Solution:
 * By Dynamic Programming we can solve the given problem by TC of O(N*Sum) while the N is the length of the array and the Sum is the given Integer we want to find its sum
 * 
 * Example:
 * 
 * set[] = {3, 4, 5, 2}
 * target/sum = 6
 * 
 *VALS/SUM --> 
 *  |
 *  v
 *      0    1    2    3    4    5    6
 *  0   T    F    F    F    F    F    F
 *  3   T    F    F    T    F    F    F
 *  4   T    F    F    T    T    F    F
 *  5   T    F    F    T    T    T    F
 *  2   T    F    T    T    T    T    T
 * 
 * We see here that the row is sort of index which goes from 0 to 6 (included) and the cols are all the values in the set/array (the 0 in the cols is optional)
 * First we fill the 0's on rows and cols with T (on cols) and F (on rows)
 * val 3: Now let's start with 3, we fill everything with F until we reach the 3 in the rows, Then we ask 3-3 is ? 0, we go to upper row at index 0 and copy-paste the T/F there (in this case it's T) 
 *        now we continue to value 3 and sum 4, we ask 4-3 is ? 1, we head over to index 1 in the row above we see it's F then we copy-paste, actually we can't have any of the sums 5 and 6 just with 3 so we mark them all false.
 * 
 * val 4: We head to value 4 and copy paste everyhing from the line above until we reach sum 4, 4-4 is ? 0, we head to sum 0 and copy paste the answer, we continue to 5 and we ask can we get a 5 with just two numbers 3,4? NO. If we want to be sure
 *        we use the method 5 - 4 is ? 1 , we head to index 1 in sum on val 3 and we get an F and so on... That's pretty much the method.
 * 
 * - let us jump to the bottom line where the answer suppose to be (on the last cell bottom right) -
 * val 2: We copy paste all the values in the cell above, until we reach sum 6, then we ask 6 - 4 is ? 4. We head to index 4 (or 2 numbers back (count from 0) 6..5..4) then we see what's in the upper val (5) index 4 cell ? it is T.
 * 
 * Happy ending: If bottom right cell is T it means such sum exists within the set/array, in our case what can give us 6 is 4 and 2. 
 * 
 * Credits goes to:
 * https://www.youtube.com/watch?v=dJmyfFC3-3A&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF  
 */
class SubSetSum{   
        // TC of O(sum)
        static boolean isPossible(int elements[], int sum)
        {
            int dp[] = new int[sum + 1];
            // initializing with 1 as sum 0 is always possible
            dp[0] = 1;
            // loop to go through every element of the elements array
            for (int i = 0; i < elements.length; i++) {
                // to change the values of all possible sum
                // values to 1
                for (int j = sum; j >= elements[i]; j--) {
                    if (dp[j - elements[i]] == 1) 
                        dp[j] = 1;
                }
            }
            // if sum is possible then return 1
            if (dp[sum] == 1)
                return true;
            return false;
        }
        
        // Driver code
        public static void main(String args[])
        {
            int arr[] = {2,3,5,7,10};
            int sum = 14;
            System.out.println(isPossible(arr, sum) ? true : false);
        }
}