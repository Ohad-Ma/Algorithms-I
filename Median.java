import java.util.Arrays;
/**
 * Median problem - "Given an unsorted array, find its median"
 * The median supposed to be the average of the two middle numbers within the array.
 * 
 * let L be array length, M be the length of the array/2 and md as the median of the array.
 * if - array is sorten then md = array[M]
 * else 
 *      sort the array and we get 2 cases: 
 *         * if length is odd then md = array[M]
 *         * else md = (array[M] + (array[L-M-1]))/2
 * 
 * Time Complexity: O(nlog(n)) for the sort O(1) for choosing the Median. Therefore, O(nlog(n)) TC.
 */
public class Median {
    
    public static double findMedian(int[] array) {
        int length = array.length, mid = length/2;
        double median = 0.0;

        // Best case: Array is already sorted. Therefore, TC is O(n)
        if (isSorted(array)) return array[mid]; 
        // Worst case : Array is not sorted. Therefore, TC is O(nlog(n))
        else{
            Arrays.sort(array); //O(nlog(n))
            double medLeft = array[mid],medRight = array[array.length-mid-1];
            median = length%2 != 0 ? array[mid] : (medLeft + medRight)/2;
            return median;
        }
    }

    /**
     * Array is sorted or not
     * @param arr
     * @return Boolean
     */
    public static boolean isSorted(int[] arr){ 
        for(int i=0 ; i<arr.length-1; i++){
            if(!(arr[i] < arr[i+1])){
                return false;
            }
        }
        return true;
    }

    /*
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 6, 5, 4,7};
        //System.out.println(isSorted(nums1));
        System.out.println(findMedian(nums1));
         int[] nums2 = {1, 7, 5, 0, 9};
         System.out.println(findMedian(nums2));
    }
    */
    
}
