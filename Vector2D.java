import java.lang.Math;
import java.util.List;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D() {
        x = 0;
        y = 0;
    }


    public int distanceTo(Vector2D other) {
        double res = Math.sqrt( (other.x - this.x) * (other.x - this.x) + (other.y - this.y) * (other.y - this.y) );
        return (int) res;
    }

    public Vector2D normalize() {
        return this;
    }

    public Vector2D plus(Vector2D other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }

    public Vector2D minus(Vector2D other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }
}