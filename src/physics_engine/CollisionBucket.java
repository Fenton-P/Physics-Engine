package physics_engine;

import java.util.HashSet;
import java.util.Set;

public class CollisionBucket {
	public static int THRESHOLD = 8;
	
	private Set<PhysicsObject> entities;
	private Set<CollisionBucket> childBuckets;
	private CollisionRect box;
	
	public CollisionBucket() {
		this(new HashSet<>(), 0, 0, 0, 0);
	}
	
	public CollisionBucket(Set<PhysicsObject> entities, double x, double y, double width, double height) {
		childBuckets = new HashSet<>();
		
		box = new CollisionRect(x, y, width, height);
		this.entities = entities;
		
		checkBucketSplit();
	}
	
	public void add(PhysicsObject entity) {
		if(childBuckets.size() == 0) {
			entities.add(entity);
			checkBucketSplit();
			return;
		}
		
		placeIntoChild(entity);
	}
	
	private void placeIntoChild(PhysicsObject entity) {
		for(CollisionBucket child : childBuckets) {
			
		}
	}
	
	private void checkBucketSplit() {
		
	}
}
