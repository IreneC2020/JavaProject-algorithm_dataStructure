package coordinates;

public class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(){
        this(0, 0);
    }

    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    public Point(int x, int y){
        setLocation(x, y);
    }

    public int compareTo(Point other) {
        if(x != other.x)
            return x - other.x;
        else
            return y - other.y;
    }

    public double distanceFrom(Point other){
        return distanceFrom(other.x, other.y);
    }

    public double distanceFrom(int x, int y){
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(Object obj){
        if(obj instanceof Point){
            Point other = (Point) obj;  // TYPECAST TO ANOTHER VAR
            return x == other.x && y == other.y;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCollinear(Point second, Point third){
        // BASE CASE : All x are on horizontal line
        if(this.x == second.x && this.x == third.x)
            return true;

        // BASE CASE : All y are on vertical line
        if(this.y == second.y && this.y == third.y)
            return true;

        // CASE : When two points not three are on the same line (Division by Zero!)
        if(this.x == second.x && this.x != third.x || this.x != second.x && this.x == third.x)
            return false;

        //GENERAL CASE : REPORT IF ON DIAGONAL
        return Math.abs(this.slope(second) - this.slope(third)) < 0.0001;
    }

    public void move(int dx, int dy){
        x += dx;    // x = x + dx
        y += dy;    // y = y + dy
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double slope(Point other){
        double dx = this.x - other.x;
        double dy = this.y - other.y;

        if (dx == 0)
            throw new IllegalArgumentException("division by zero!");

        return dy / dx;
    }

    public String toString(){
        return String.format("(%d, %d)", x, y);
    }

}
