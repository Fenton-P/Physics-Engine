package physics_engine;

public class CollisionRect {
	public double x, y, width, height;
	
	public CollisionRect(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isColliding(CollisionRect other) {
		boolean xCheck = x + width >= other.x && x <= other.x + other.width;
		boolean yCheck = y + height >= other.y && y <= other.y + other.height;
		
		return xCheck && yCheck;
	}
}
