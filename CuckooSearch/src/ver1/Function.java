package ver1;

public class Function implements Comparable<Function>{
	
	private double x1;
	private double x2;
	private double fitness;
	
	public Function(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
		this.fitness = ackely(x1, x2);
	}
	
	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	@Override
	public int compareTo(Function f) {
		if(this.fitness < f.fitness) {
			return -1;
		} else if(this.fitness == f.fitness) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public double exp(double number) {
		double result = Math.pow(Math.E, number);
		return result;
	}
	
	public double rastrigin(double x1, double x2) {
		double result = -20 * exp(-0.2 * Math.sqrt(0.5 * (Math.pow(x1, 2) + Math.pow(x2, 2)))) 
				- exp(0.5 * ((Math.cos(2 * x1 * Math.PI) + (Math.cos(2 * x2 * Math.PI))))) 
				+ Math.E + 20;
		
		return result;
	}
	
	public double ackely(double x1, double x2) {
		double result = -20 * exp(-0.2 * Math.sqrt(0.5 * (Math.pow(x1, 2) + Math.pow(x2, 2)))) 
				- exp(0.5 * ((Math.cos(2 * x1 * Math.PI) + (Math.cos(2 * x2 * Math.PI))))) 
				+ Math.E + 20;
		
		return result;
	}
	
}
