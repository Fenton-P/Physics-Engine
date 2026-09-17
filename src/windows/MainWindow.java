package windows;

import javax.swing.*;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 3445049087872414636L;
	
	private PhysicsPanel phys;
	
	public MainWindow() {
		phys = new PhysicsPanel();
		
		this.add(phys);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		phys.beginSim();
	}
}
