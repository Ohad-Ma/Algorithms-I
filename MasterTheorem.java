/**
 * The master theorem was invnented in order to make an ease on our lives calculating Time Complexity instead of
 * writing many recursive steps. Wonderful! (right?)
 *  
 * This class represent the Master Theorem calculation, all you have to do is to enter
 * variables a,b & d from the formula: a*T([n/b]) + O(n^d)
 * 
 * if:
 *  * d < log_b(a) -> O(n^(log_b(a)))
 *  * d = log_b(a) -> O(n^d*log(n))
 *  * d > log_b(a) -> O(n^d)
 */

public class MasterTheorem {
    public static void masterFunction(int a,int b,double d){
       System.out.println(d < logOfBase(b,a) ? "O(n^(" +logOfBase(b,a)+ "))" :
                            d > logOfBase(b,a) ? "O(n^"+(int)d+")" :
                                            "O(n^"+(int)d+"*log(n)"); 
    }

    /**
     * Calculate log_b(a) while b is the base
     * @param base
     * @param num
     * @return answer of the log
     */
    public static double logOfBase(int base, int num) {
        return Math.log(num) / Math.log(base);
    }

}
