/**
 * Longest Common Prefix algorithm implemented by using Divide and Conquer idea -
 * "Divide the array to two parts and merge the LCP of both the subparts."
 * > Divide the array into two sub arrays recursivley like in merge sort (without the sorting)
 * > Merge the result of the sub arrays which will be the desired answer
 * 
 * Complexity:
 * O(m*log(n)) Where n is the amount of recursive calls and m is the space to store the result
 * 
 * Recursive formula:
 * h(n) = 2h(n/2) + n/2
 */
public class LongestCommonPrefix{
    public static String LCP(String[] s, int start, int end) {
        // Similar to merge sort -> we cut recursively the array into two sides
        if (start == end) return s[start];
        int mid = (start + end)/2;
        String lcpLeft = LCP(s,start,mid); // left array string
        String lcpRight = LCP(s,mid+1,end); // right array string

        return common_prefix(lcpLeft,lcpRight); // "merge" into the answer

    }
    /**
     * Helping function which returns the common prefix on each strings and returns it
     * @param s1 first string
     * @param s2 second string
     * @return answer string
     */
    public static String common_prefix(String s1,String s2){
        int len = Math.min(s1.length(), s2.length()); // find the shortest string.
        for (int i = 0; i< len; i++){ // compare both chars on each string.
            if (s1.charAt(i) != s2.charAt(i)){ // if they are not equal returns the string till two of them were equals.
                return s1.substring(0, i); // if shortest string is found on the other string and they are equal returns as is.
            }
        }
        return s1.substring(0, len);
    }

    /* Main function to check the algorithm
    public static void main(String[] args) {
        String[] str = {"algebra","algorithms","algeir","algory"};
        System.out.println(LCP(str,0,3));
    }
    */
}
