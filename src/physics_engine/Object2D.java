package physics_engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Object2D implements PhysicsObject {
	protected Vector position, velocity;
	protected double mass;
	protected Set<Force> forces;

	@Override
	public CollisionResponse handlCollision(PhysicsObject o) {
		// TODO Auto-generated method stub
		return null;
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
