package sherwood.cells.physics;

import java.awt.Point;

public class ForceVector {
	private boolean polarCached;
    private PolarVector polarForce;
	private boolean cartesianCached;
	private Point.Double cartesianForce;
	public Point.Double position;

	public ForceVector(PolarVector force) {
		this(force, new Point.Double());
	}

	public ForceVector(PolarVector force, Point.Double position) {
		this.polarForce = force;
		polarCached = true;
		this.position = position;
	}

	public ForceVector(Point.Double force) {
		this(force, new Point.Double());
	}

	public ForceVector(Point.Double force, Point.Double position) {
		this.cartesianForce = force;
		cartesianCached = true;
		this.position = position;
	}

	public PolarVector getPolarForce() {
		if(!polarCached) {
			polarForce = PolarVector.fromCartesian(cartesianForce);
			polarCached = true;
		}
		return polarForce;
	}

	public Point.Double getCartesianForce() {
		if(!cartesianCached) {
			cartesianForce = polarForce.toCartesian();
			cartesianCached = true;
		}
		return cartesianForce;
	}

    public static ForceVector add(ForceVector vector1, ForceVector vector2) {
		ForceVector result;
		if(vector1 == null) {
			result = vector2;
		} else if(vector2 == null) {
			result = vector1;
		} else {
			throw new RuntimeException("not yet implemented");
		}
		return result;
    }
}
