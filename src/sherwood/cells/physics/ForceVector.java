package sherwood.cells.physics;

public class ForceVector {
    public double angle;
    public double magnitude;

    public ForceVector(double angle, double magnitude) {
        this.angle = angle;
        this.magnitude = magnitude;
    }

    public static ForceVector add(ForceVector vector1, ForceVector vector2) {
		ForceVector result;
		if(vector1 == null) {
			result = vector2;
		}
		else if(vector2 == null) {
			result = vector1;
		}
		else {
			throw new RuntimeException("not implemented");
		}
		return result;
    }
}
