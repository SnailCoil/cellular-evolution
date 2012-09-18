package sherwood.cells.physics;

import java.awt.geom.Point2D;

public class PolarVector {
	public double angle, magnitude;

	public PolarVector(double angle, double magnitude) {
		this.angle = angle;
		this.magnitude = magnitude;
	}

	public Point2D.Double toCartesian() {
		return new Point2D.Double(Math.cos(angle)*magnitude, Math.sin(angle)*magnitude);
	}

	public static PolarVector fromCartesian(Point2D.Double v) {
		return new PolarVector(Math.atan2(v.y, v.x), v.distance(0,0));
	}
}
