package physics_engine;

import java.util.ArrayList;

public class Force {
	private ArrayList<Double> x, y;
	public double start, finish;
	
	public Force(Vector v, double start, double finish) {
		x = new ArrayList<>();
		y = new ArrayList<>();
		
		x.add(v.x);
		y.add(v.y);
		
		this.start = start;
		this.finish = finish;
	}
	
	public boolean isDead() {
		return finish <= 0 || finish <= start;
	}
	
	public void tick(double deltaT) {
		start -= deltaT;
		finish -= deltaT;
	}
	
	public Vector getDeltaV(double deltaT, double mass) {
		if(start - deltaT > 0) {
			return new Vector(0, 0);
		}
		
		if(finish - deltaT < 0) {
			deltaT = finish;
		}
		
		double dVx = sum(calculateIntegral(x, 1), deltaT);
		double dVy = sum(calculateIntegral(y, 1), deltaT);
		
		return new Vector(dVx / mass, dVy / mass);
	}
	
	public Vector getDeltaX(double deltaT, double mass) {
		if(start - deltaT > 0) {
			return new Vector(0, 0);
		}
		
		if(finish - deltaT < 0) {
			deltaT = finish;
		}
		
		double dx = sum(calculateIntegral(x, 2), deltaT);
		double dy = sum(calculateIntegral(y, 2), deltaT);
		
		return new Vector(dx / mass, dy / mass);
	}
	
	//Assumes position and velocity are accounted for in some other method
	private ArrayList<Double> calculateIntegral(ArrayList<Double> coef, int iter) {
		return calcIntAux(new ArrayList<Double>(coef), iter);
	}
	
	private ArrayList<Double> calcIntAux(ArrayList<Double> coef, int iter) {
		if(iter <= 0) return coef;
		
		for(int i = 0;i < coef.size();i++) {
			coef.set(i, coef.get(i) / (i + 1));
		}
		
		coef.add(0, 0.);
		
		return calcIntAux(coef, iter - 1);
	}
	
	private double sum(ArrayList<Double> arr, double deltaT) {
		double sum = 0;
		
		for(int i = 0;i < arr.size();i++) {
			sum += arr.get(i) * Math.pow(deltaT, i);
		}
		
		return sum;
	}
}
