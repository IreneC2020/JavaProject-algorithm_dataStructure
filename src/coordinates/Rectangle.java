package coordinates;

public class Rectangle implements Comparable<Rectangle> {
    private double height;
    private double width;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width  = width;
    }

    public double area() {
        return width * height;
    }

    public static int compareAreas(Rectangle r1, Rectangle r2) {
        return Double.compare(r1.area(), r2.area());
    }

    public static int comparePerimeters(Rectangle r1, Rectangle r2) {
        return Double.compare(r1.perimeter(), r2.perimeter());
    }

    public int compareTo(Rectangle other) {
        if(width != other.width) {
            return Double.compare(width, other.width);
        }else {
            return Double.compare(height, other.height);
        }
    }

    public boolean equals(Object other) {
        if(other instanceof Rectangle) {
            Rectangle r = (Rectangle) other;
            return width == r.width && height == r.height;
        }
        return false;
    }

    public double perimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f]", width, height);
    }
}
