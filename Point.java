public class Point implements point_info {
    public double x,y;
    //#region constructors
    public Point(){this.x=this.y=0;}

    
    public Point(double x, double y){
        this.x = x; this.y=y;
    }
    //#endregion


    @Override
    /**
     * print objects as '(x,y)'
     */
    public String toString() {
        return String.format("(%lf , %lf)", this.x,this.y);
    }

    @Override
    /**
     * for comparsion
     */
    public int hashCode(){
        return Double.hashCode(x)^Double.hashCode(y);
    };

    @Override
    /**
     * comapre between objects
     */
    public boolean equals(Object obj){
        if (obj instanceof Point) {
            Point other = (Point) obj;
            return x == other.x && y == other.y;
        } else {
            return false;
        }
    }
    
}
