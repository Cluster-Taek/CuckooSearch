package ver1;

public class Function implements Comparable<Function>{
	
	private double x;
	private double y;
	private double fitness;
	
	public Function(double x, double y) {
		this.x = x;
		this.y = y;
		this.fitness = ackely(x, y);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
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
	
	
	
	public double ackely(double x, double y) {
		double result = -20 * exp(-0.2 * Math.sqrt(0.5 * (Math.pow(x, 2) + Math.pow(y, 2)))) 
				- exp(0.5 * ((Math.cos(2 * x * Math.PI) + (Math.cos(2 * y * Math.PI))))) 
				+ Math.E + 20;
		
		return result;
	}
	
	public double beale(double x, double y) {
		double result = Math.pow((1.5 - x + (x * y)), 2) + Math.pow((2.25 - x + (x * y * y)), 2)
				+ Math.pow(2.625 - x + (x * y * y * y), 2);
		
		return result;
	}
	
	public double easom(double x, double y) {
		double result = - (Math.cos(x) * Math.cos(y) 
				* exp(-(Math.pow(x - Math.PI, 2) + Math.pow(x - Math.PI, 2))));
				
		return result;
	}
	
	public double eggholder(double x, double y) {
		double result = - (y + 47) * Math.sin(Math.sqrt(Math.abs((x / 2) + y + 47))) 
				- (x * Math.sin(Math.sqrt(Math.abs(x - y + 47))));
				
		return result;
	}
	
	public double himmelblau(double x, double y) {
		double result = Math.pow((x * x) + y - 11, 2) + Math.pow(x + (y * y) - 7, 2);
				
		return result;
	}
	
	
}
