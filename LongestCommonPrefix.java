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
        if (start == end) return s[start];
        int mid = (start + end)/2;
        String lcpLeft = LCP(s,start,mid);
        String lcpRight = LCP(s,mid+1,end);

        return common_prefix(lcpLeft,lcpRight);

    }
    public static String common_prefix(String s1,String s2){
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i< len; i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0, i);
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
