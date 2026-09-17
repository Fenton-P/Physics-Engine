package physics_engine;

import java.awt.Graphics2D;

public class Circle implements PhysicsObject {
	private Vector position;
	private double radius;
	
	public Circle() {
		this(0, 0, 1);
	}
	
	public Circle(double x, double y, double rad) {
		position = new Vector(x, y);
		radius = rad;
	}

	@Override
	public CollisionResponse handlCollision(PhysicsObject o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics2D paint) {
		int ovalX = (int) (position.x - radius / 2 + .5);
		int ovalY = (int) (position.y - radius / 2 + .5);
		int size = (int) (radius * 2);
		
		paint.fillOval(ovalX, ovalY, size, size);
	}

}
