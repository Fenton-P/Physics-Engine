package physics_engine;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Circle implements PhysicsObject {
	private Vector position, velocity;
	private double radius, mass;
	
	private Set<Force> forces;
	
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

	@Override
	public void setVelocity(Vector v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector getVelocity() {
		return velocity;
	}

	@Override
	public void setPosition(Vector v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyForce(Vector v, double start, double finish) {
		applyForce(new Force(v, start, finish));
	}

	@Override
	public void applyForce(Force f) {
		forces.add(f);
	}

	@Override
	public ArrayList<Force> getForces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tick(double deltaT) {
		position.add(velocity.getScaled(deltaT));
		Set<Force> deadForces = new HashSet<>();
		for(Force f : forces) {
			velocity.add(f.getDeltaV(deltaT, mass));
			position.add(f.getDeltaX(deltaT, mass));
			f.tick(deltaT);
			if(f.isDead()) deadForces.add(f);
		}
		forces.removeAll(deadForces);
	}

	@Override
	public void getMass() {
		// TODO Auto-generated method stub
		
	}

}
