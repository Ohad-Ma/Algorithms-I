/**
 * The purpose of the algorithm is to find contiguous max in an array, after can be changed onto 2D arrays (matrices)
 * credit goes to gfg:
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * --------------------------------
 * algorithm:
 *
 * Initialize:
 *     max_so_far = INT_MIN
 *     max_ending_here = 0
 *
 * Loop for each element of the array
 *   (a) max_ending_here = max_ending_here + a[i]
 *   (b) if(max_so_far < max_ending_here)
 *             max_so_far = max_ending_here
 *   (c) if(max_ending_here < 0)
 *             max_ending_here = 0
 * return max_so_far
 *
 * ----------------------------------
 *
 * example:
 *     {-2, -3, 4, -1, -2, 1, 5, -3}
 *
 *     max_so_far = max_ending_here = 0
 *
 *     for i=0,  a[0] =  -2
 *     max_ending_here = max_ending_here + (-2)
 *     Set max_ending_here = 0 because max_ending_here < 0
 *
 *     for i=1,  a[1] =  -3
 *     max_ending_here = max_ending_here + (-3)
 *     Set max_ending_here = 0 because max_ending_here < 0
 *
 *     for i=2,  a[2] =  4
 *     max_ending_here = max_ending_here + (4)
 *     max_ending_here = 4
 *     max_so_far is updated to 4 because max_ending_here greater
 *     than max_so_far which was 0 till now
 *
 *     for i=3,  a[3] =  -1
 *     max_ending_here = max_ending_here + (-1)
 *     max_ending_here = 3
 *
 *     for i=4,  a[4] =  -2
 *     max_ending_here = max_ending_here + (-2)
 *     max_ending_here = 1
 *
 *     for i=5,  a[5] =  1
 *     max_ending_here = max_ending_here + (1)
 *     max_ending_here = 2
 *
 *     for i=6,  a[6] =  5
 *     max_ending_here = max_ending_here + (5)
 *     max_ending_here = 7
 *     max_so_far is updated to 7 because max_ending_here is
 *     greater than max_so_far
 *
 *     for i=7,  a[7] =  -3
 *     max_ending_here = max_ending_here + (-3)
 *     max_ending_here = 4
 *
 *-------------------------------------------------
 *
 */
public class KadaneAlgorithm {
    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    /*
    public static void main(String[] args)
    {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        int max_sum = maxSubArraySum(a, n);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }
    */
}
