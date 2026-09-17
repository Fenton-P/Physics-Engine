package physics_engine;

public class Force {
	public Vector force;
	public double start, finish;
	
	public Force(double x, double y, double start, double finish) {
		force = new Vector(x, y);
		
		this.start = start;
		this.finish = finish;
	}
}
