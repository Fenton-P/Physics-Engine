package physics_engine;

import java.awt.*;
import java.util.*;

public class PhysicsEngine {
	private Thread physicsThread;
	private double tickRate, deltaTime;
	
	private Set<PhysicsObject> physicsObjects;
	
	public PhysicsEngine() {
		this(20);
	}
	
	public PhysicsEngine(double tickRate) {
		physicsObjects = new HashSet<>();
		this.tickRate = tickRate;
	}
	
	public void start() {
		physicsThread = new Thread(this::update);
		physicsThread.start();
	}
	
	public void drawObjects(Graphics2D paint) {
		for (PhysicsObject o : physicsObjects) {
			o.draw(paint);
		}
	}
	
	private void update() {
		while (physicsThread != null) {
			long beforeExecution = System.currentTimeMillis();
			
			tick();
			
			long afterExecution = System.currentTimeMillis();
			deltaTime = afterExecution - beforeExecution;
			long delay = (long) (1000d / tickRate + .5 - deltaTime);
			deltaTime = delay / 1000.;
			delay = delay < 0 ? 0 : delay;
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addObject(PhysicsObject o) {
		physicsObjects.add(o);
		o.applyForce(new Vector(10, 0), 1, 10);
	}
	
	private void tick() {
		applyForces();
	}
	
	private void applyForces() {
		for(PhysicsObject o : physicsObjects) {
			o.tick(deltaTime);
		}
	}
}
