package sherwood.cells.physics;

public class ForceVector {
    public double x, y;
    public double angle;
    public double magnitude;

    public ForceVector(double x, double y, double angle, double magnitude) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.magnitude = magnitude;
    }
}
