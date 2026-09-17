package physics_engine;

import java.awt.Graphics2D;
import java.util.ArrayList;

public interface PhysicsObject {
	public CollisionResponse handlCollision(PhysicsObject o);
	
	public void draw(Graphics2D paint);
	
	public void setVelocity(Vector v);
	public Vector getVelocity();
	public void setPosition(Vector v);
	public Vector getPosition();
	public void applyForce(Vector v, double start, double finish);
	public void applyForce(Force f);
	public ArrayList<Force> getForces();
	public void tick(double deltaT);
	public void getMass();
}
