import java.util.Arrays;

/**
 * There are n costumers there are waiting in the waiting room, the secretary goal is to reduce the waiting time of the costumers
 * as possible.
 * 
 * In the solution we prove that sorting the queue from the shortest to the highest is the most efficient.
 * TC: O(n*log(n))
 * 
 * AVG = (T1 + T2 +....+Tn)/n -> min
 * we only have to find the minimum sum which will give us the best result.
 * proof:
 * sum = T1+...T(i-1)+T(i)+T(i+1)+....+T(n) = T1 +...+(T1 +.... + T(i-1)) + (T1 + ... + T(i-1)+ T(i)) + (T1 + ... + T(i-1)+ T(i) + T(i+1)) + ... + (T1 + ... + T(i-1)+ T(i) + T(i+1) + ... + T(n))
 * 
 * Let assume falsely that the waiting time T(i) (some var in the unsorted array) is BIGGER then the next var waiting time AKA T(i) > T(i+1). Let us swap between them: 
 * sum' = T1+...T(i-1) +T(i+1) +T(i)+....+T(n) = T1 +...+(T1 +.... + T(i-1)) + (T1 + ... + T(i-1)+ T(i+1)) + (T1 + ... + T(i-1) + T(i+1) + T(i)) + ... + (T1 + ... + T(i-1) + T(i+1) + T(i)  + ... + T(n))
 * 
 * Now let us substract sum - sum' = T(i) - T(i+1) > 0. 
 * In other words: sum' < sum
 * 
 * Therefore, we get that the avg time is shorter when the nearby vars are upsort. 
 * To conclude; The secretary have to sort the waiting time from the shortest to the longest 
 */
public class TheSecretaryProblem {
    public static double getAverageTime(int[] times){
        Arrays.sort(times);
        double avg = 0;
        for (int x : times) avg += avg + x;
        return avg/times.length; 
    }
}
