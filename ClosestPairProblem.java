import java.util.ArrayList;
import java.util.List;

/**
 * Closest Pair Problem: find the closest two points.
 * 
 *  O(nlog(n)) -> Let Time complexity of the algorithm be T(n). Let us assume that we use a O(nLogn) sorting algorithm. The algorithm divides all points in two sets and
 *  compares both points on each set (the lambda expression function).
 * Then going all over the list O(n) measuring the smallest distance. Then returning both points (p1,p2) as pair in a list. Therefore, we have :
 *  T(n) = 2T(n/2) + O(n) + O(n) + O(n) 
 *   T(n) = 2T(n/2) + O(n) 
 *  T(n) = T(nLogn)
 */

public class ClosestPairProblem {
    public static List<Point> closestPair(List<Point> points){
        // ArrayList declaration. 
        final List<Point> arr = new ArrayList<>(points);
        arr.sort((p1,p2) -> Double.valueOf(p1.x).compareTo(Double.valueOf(p2.x))); // O(nLog(n))
        //variable len as length of points list
        final int len = points.size();
        // variable l as Maximum value of double (around 1.7976931348623157E+308)
        double l = Double.valueOf(Integer.MAX_VALUE);
        double tolerance = Math.sqrt(l);
        int p1 = 0, p2 = 0;

        for (int i = 0; i+1 < len; i++){ // O(n)
            for (int j = i+1; j<len; j++){
                if (arr.get(j).x >= arr.get(i).x + tolerance) break;
                // calculate distance using the formula
                final double ls = Math.pow(arr.get(i).x - arr.get(j).x, 2) + 
                                    Math.pow(arr.get(i).y - arr.get(j).y, 2);
                if (ls < l){
                    l = ls;
                    tolerance = Math.sqrt(l); // O(log(n))
                    p1 = i; p2 = j;
                }
            }
        }
        // answer returned as a list
        final List<Point> pair = new ArrayList<Point>();
        pair.add(arr.get(p1));
        pair.add(arr.get(p2));
        return pair;
    }
    
    

}
