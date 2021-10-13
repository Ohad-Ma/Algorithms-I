/**
 * Closest Pair Problem: find the closest two points.
 * This algorithm will be implemented via brute force way and not divide and conquer
 * 
 * Time complexity: O(nlog(n)) -> Let Time complexity of above algorithm be T(n). Let us assume that we use a O(nLogn) sorting algorithm. The above algorithm divides all points in two sets and recursively calls for two sets. After dividing,
 * it finds the strip in O(n) time. Also, it takes O(n) time to divide the Py array around the mid vertical line. Finally finds the closest points in strip in O(n) time. So T(n) can be expressed as follows 
T(n) = 2T(n/2) + O(n) + O(n) + O(n) 
T(n) = 2T(n/2) + O(n) 
T(n) = T(nLogn)
 */

public class ClosestPairProblem {
    public class Point{
        int x,y;
        public String toString(){
            return String.format("(%d , %d)", this.x,this.y);
        }
    }
    /**
     * Distance calculation function according to the formula
     * @param p1 First point
     * @param p2 Second point
     * @return distance as double
     */
    public static double distCal(Point p1, Point p2){
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) +
        (p1.y - p2.y)*(p1.y - p2.y)
      );
    }
    
    // TODO: Finish writing the functions

}
