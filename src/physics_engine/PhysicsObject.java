package physics_engine;

import java.awt.Graphics2D;

public interface PhysicsObject {
	public CollisionResponse handlCollision(PhysicsObject o);
	
	public void draw(Graphics2D paint);
}
