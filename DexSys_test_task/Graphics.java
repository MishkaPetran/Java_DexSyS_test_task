import java.util.ArrayList;
import java.util.HashSet;

public class Graphics {
    int degree;
    HashSet points;

    public Graphics(int degree) {
        this.degree = degree;
        this.points = new HashSet();
    }

    public Graphics() {
        this.points = new HashSet();
    }

    public boolean isHit (int x, int y){
        if (y >= Math.pow(x, this.degree)) {
            return true;
        } else {
            return false;
        }
    }

    public HashSet setPoints(String points) {
        this.points.add(points);
        return this.points;
    }

    public int getSize() {
        return this.points.size();
    }

    public HashSet getPoints() {
        return points;
    }

    public HashSet clearPoints() {
        this.points.clear();
        return this.points;
    }
}
