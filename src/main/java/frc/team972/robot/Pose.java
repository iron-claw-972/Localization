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
	
	public void translate(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void rotate(double angle) {
		this.heading += angle;
	}
}