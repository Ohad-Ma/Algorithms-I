/**
 * Maximum Sub Array problem implemented using Kadanes's Algorithm (Dynamic programming approach)
 *      "maintain the maximum possible sum of a subarray ending at an index without needing
 *                      to store the numbers in an auxiliary array"
 * 
 * Time complexity O(n), Space Complexity O(1)
 *  
 */
public class MaximumSubArray{
    public static int maximumSubArray(int[] arr){
        int max_current,max_global; // two variables to store the max and the current
        max_current = max_global = arr[0];
        for (int i = 0; i<arr.length-1; i++){
            max_current = Math.max(arr[i], max_current + arr[i]); // check for maximum between max and current
            if (max_current > max_global) max_global = max_current; // if current subarray has bigger value then the new max global will be the max current
        }
        return max_global; // returns the answer
    }

    
    /*
    public static void main(String[] args) {
        int arr[] = {-2,3,2,-1};
        System.out.println(maximumSubArray(arr));
    }
    */
}