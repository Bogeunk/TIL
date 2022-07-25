class Point1 implements Cloneable {
    int x, y;

    Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "x=" + x + ", y=" + y;
    }

    public Point1 clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}
        return (Point1)obj;
    }
}

public class CloneEx1 {
    public static void main(String[] args) {
        Point1 original = new Point1(3, 5);
        Point1 copy = original.clone();
        System.out.println(original);
        System.out.println(copy);
    }
}
