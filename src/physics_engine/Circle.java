package physics_engine;

import java.awt.Graphics2D;
import java.util.HashSet;

public class Circle extends Object2D {
	private double radius;
	
	public Circle() {
		this(0, 0, 1);
	}
	
	public Circle(double x, double y, double rad) {
		position = new Vector(x, y);
		velocity = new Vector(0, 0);
		radius = rad;
		mass = 1.;
		
		forces = new HashSet<>();
	}

	@Override
	public void draw(Graphics2D paint) {
		int ovalX = (int) (position.x - radius / 2 + .5);
		int ovalY = (int) (position.y - radius / 2 + .5);
		int size = (int) (radius * 2);
		
		paint.fillOval(ovalX, ovalY, size, size);
	}
}
