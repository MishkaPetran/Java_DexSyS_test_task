public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPoint(Point point){
        String p = "P(" + point.getX() + ";" + point.getY() + ")";
        return p;
    }

    @Override
    public String toString() {
        return "Dot {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
