package frc.team972.robot;


public class Pose {
	private double x;
	private double y;
	private double heading;
	
	public Pose() {
		this(0, 0, 0);
	}
	
	public Pose(double x, double y, double heading) {
		this.x = x;
		this.y = y;
		this.heading = heading;
	}
	
	public void translate(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void setCoordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void rotate(double angle) {
		this.heading += angle;
	}

	public void setHeading(double _heading) {
		heading = _heading;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getHeading() {
		return heading;
	}
	

}