package windows;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import physics_engine.Circle;
import physics_engine.PhysicsEngine;

public class PhysicsPanel extends JPanel {
	private static final long serialVersionUID = -8930833449448022109L;
	
	private PhysicsEngine world;
	private final int X_SCALE = 16, Y_SCALE = 9;
	private BufferedImage renderImage;
	
	public PhysicsPanel() {
		this.setPreferredSize(new Dimension(800, 450));
		
		world = new PhysicsEngine();
		
		Circle circle = new Circle(200, 200, 50);
		world.addObject(circle);
		
		renderImage = new BufferedImage(1600, 900, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D paint = (Graphics2D) renderImage.getGraphics();

		paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		paint.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		paint.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		
		paint.clearRect(0, 0, renderImage.getWidth(), renderImage.getHeight());
		
		draw(paint);
		
		int width = getWidth();
		int height = getHeight();
		
		double x = (double) width / X_SCALE;
		double y = (double) height / Y_SCALE;
		
		int scale = (int) (Math.min(x, y) + .5);
		((Graphics2D) g).drawImage(renderImage, 0, 0, scale * X_SCALE, scale * Y_SCALE, null);
	}
	
	private void draw(Graphics2D paint) {
		world.drawObjects(paint);
	}
}
