package physics_engine;

public class Vector {
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double mag() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vector getNormalized() {
		double mag = mag();
		if(mag == 0) return this;
		return new Vector(x / mag, y / mag);
	}
	
	public void add(Vector other) {
		x += other.x;
		y += other.y;
	}
	
	public Vector getScaled(double scale) {
		return new Vector(x * scale, y * scale);
	}
	
	public String toString() {
		return "X: " + x + ", Y: " + y;
	}
}
