import java.util.Arrays;

/**
 *  Input: a list P of points in the plane.

    Precondition: There must be at least 3 points.

  1)  Sort the points of P by x-coordinate (in case of a tie, sort by y-coordinate).

  2)  Initialize U and L as empty lists.
      The lists will hold the vertices of upper and lower hulls respectively.

  3)  for i = 1, 2, ..., n:
        while L contains at least two points and the sequence of last two points
                of L and the point P[i] does not make a counter-clockwise turn:
                remove the last point from L
        append P[i] to L

  4)  for i = n, n-1, ..., 1:
        while U contains at least two points and the sequence of last two points
                of U and the point P[i] does not make a counter-clockwise turn:
                remove the last point from U
        append P[i] to U

  5)  Remove the last point of each list (it's the same as the first point of the other list).
  6)  Concatenate L and U to obtain the convex hull of P.
  7)  Points in the result will be listed in counter-clockwise order.
 */
class AndrewAlgorithm{
    class Point{
        int x,y;
        Point (int x,int y){
            this.x = x;
            this.y = y;
        }

        // sort first on x then on y
        public int compareTo(Point other) {
            if(this.x == other.x){
                return y - other.y;
            }else{
                return x - other.x;
            }
        }

        /**
         * Cross multiplication of two Points
         * @param p
         * @return
        */
        public int cross(Point p) {
            return (this.x*p.y - this.y*p.x);
        }

        /**
         * Substraction of two Points
         * @param p
         * @return
         */
        public Point sub(Point p) {
            return new Point(this.x - p.x, this.y - p.y);
        }
     
        public String toString(){
            return String.format("(%d,%d)", this.x,this.y);
        }
    }

    public Point[] findAndrew(Point[] points){
        int n = points.length;
        // Sort the points
        Arrays.sort(points);
        // n * 2 points in between the convex
        Point[] answer = new Point[n * 2];
        int k = 0;
        // first insertion point
        int start = 0;
        
        // Low layer hull
        for(int i = 0; i < n; i++){
            Point p = points[i];
            while( k - start >= 2 && p.sub(answer[k-1]).cross(p.sub(answer[k-2])) > 0){
                k--;
            }
            answer[k++] = p;
        }

        // Go lower level
        k--; 
        // Start at different point
        start = k;

        // Top layer hull
        for(int i = n-1; i >= 0; i--){ 
            Point p = points[i];
            while( k - start >= 2 && p.sub(answer[k-1]).cross(p.sub(answer[k-2])) > 0){
                k--;
            }
            answer[k++] = p;
        }
        
        // Last point
        k--;
        
        return Arrays.copyOf(answer, k);
    }




}