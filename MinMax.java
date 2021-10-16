import java.util.Arrays;

/**
 * find MinMax within an array Non-recursive algorithm
 * Time Complexity: O(n)
 * 
 * Total number of comparisons: 
 *  * if n is odd: 3*(n-1)/2
 *  * if n is even: 1+3*(n-2)/2 = 3*n/2 - 2 
 * 
 * steps:
 *  create max,min vars
 *  check array size:
 *          if odd => init min and max to the first element
 *          else => compare the elements and set min to the smaller value and max to the bigger value
 * 
 *  traverse array in pairs
 *  for each pair compare the two elements and then compare the bigger element with max
 *  for each pair compare the two elements and then compare the smaller element with min
 * 
 *  update one of each if require***
 * 
 * return max and min as an array
 */

public class MinMax {
    
    public static int[] findMinMax(int A[], int n){
        int min,max,i;
        if(n%2 != 0){
            max = min = A[0];
            i = 1;
        }
        else {
            max = A[0];
            min = A[1];
            i = 2;
        }
        while (i< n){
            if( A[i] < A[i+1]){
                if (A[i] < min) min = A[i];
                if (A[i+1] > max) max = A[i+1];
            }else{
                if ( A[i] > max) max = A[i];
                if ( A[i+1] < min) min = A[i+1];
            }
            i += 2;
        }
        int ans[] = {max, min};
        return ans;
    }

    /* Check the function
    public static void main(String[] args) {
        int[] arr = {4,3,5,10,1,2,7,11,6,8};
        System.out.println(Arrays.toString(findMinMax(arr, arr.length-1)));
    }
     */

}
