import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Problem: 
 * Given a set S of n points in a plane.
 * 
 * The convex hull of S is a convex polygon P, 
 * with vertices in S, that contains all the points of S
 * 
 * Find the convex hull
 * 
 * 
 * Solution:
 * 
 * Using Graham's algorithm we can find the convex hull.
 * 
 * Input: Sequence of n points p1=(x_1,y_1),....,pn = (x_n,y_n)
 * Output: Vertices of the CH, in CLOCKWISE order
 * 
 * 
 * Psuedo code:
 * 
 * Step 1: Find a point q1 that is certainly a CH vertex,
 *         say point with lowest y-coordinate 
 * 
 * Step 2: Sort the remaining points clockwise w.r.t q1 
 *         *Whenever the sorting algorithm asks "is r<s?" we check
 *          whether r,q1,s make a LEFT TURN
 * 
 * Step 3: 
 *          
 *      Initalize a stack to S = (q1,q2)
 * 
 *      for i = 3 to n:
 *          While S[-2],S[-1],qi make a left turn
 *              S.pop()
 *          S.push(qi)
 *      return the points in S
 * 
 * Time Complexity: 
 *                  Step 1 = O(n)
 *                  Step 2 = O(nlog(n))
 *                  Step 3 = O(n) 
 *                  \/\/\/\/\/\/
 *          O(n) + O(nlog(n)) + O(n) = 2O(n) + O(nlog(n)) = O(nlog(n))
 * 
 * 
 * credit: https://www.youtube.com/watch?v=B2AJoQSZf4M&ab_channel=StableSort              
 */
class GrahamScan{
    
    private void sortByAngle(List<? extends Point> points, Point ref) {
        Collections.sort(points, (b,c) -> {
            
            if (b == ref) return -1;
            if (c == ref) return 1;

            int counterClockWise = ccw(ref, b, c);

            if (counterClockWise == 0){
                if (Float.compare((float)b.x,(float)c.x) == 0) {
					/*
					 * rare case of floats matching up in a vertical line, we want 
					 * the closer point to be first
					 */
					return b.y < c.y ? -1 : 1;				
				} else {
					return b.x < c.x ? -1 : 1;				
				}				
			} else {
				return counterClockWise * -1;
            }
        });
    }

    static int ccw(Point a, Point b, Point c) {
		/*
		 * determinant (the cross product) calculates the signed area of parallelogram
		 */
		float area = (float) ((b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x));
		
		if (area < 0) return -1; // clockwise
		
		if (area > 0) return 1; // counter-clockwise
		
		return 0; // collinear
	}

    	/**
	 * finds the bottom most, left most point
	 * @param points
	 * @return
	 */
	static Point getMinY(Collection<? extends Point> points) {
		
		Iterator<? extends Point> it = points.iterator();
		Point min = it.next();
		
		while (it.hasNext()) {
			Point point = it.next();
			if (point.y <= min.y) {
				if (point.y < min.y) {
					min = point;
				} else if (point.x < min.x) { // point.y==min.y, pick left most one
					min = point;
				}
			}
		}
		
		return min;
	}

    public List<Point> grahamScan(List<? extends Point> points){
        Deque<Point> stack = new ArrayDeque<>();

        Point minYPoint = getMinY(points);
        sortByAngle(points, minYPoint);

        stack.push(points.get(0));
        stack.push(points.get(1));

        for (int i = 2, size = points.size(); i < size; i++){
            Point next = points.get(i);
            Point p = stack.pop();

            while(stack.peek() != null && ccw(stack.peek(), p, next) <= 0){
                p = stack.pop();
            }

            stack.push(p);
            stack.push(points.get(i));
        }

        Point p = stack.pop();
        if (ccw(stack.peek(), p, minYPoint) > 0){
            stack.push(p);
        }

        return new ArrayList<>(stack);
    }
}