package ver1;

public class Function {
	
	public double exp(double number) {
		double result = Math.pow(Math.E, number);
		return result;
	}
	public double ackely(double x1, double x2) {
		double result = -20 * exp(-0.2 * Math.sqrt(0.5 * (Math.pow(x1, 2) + Math.pow(x2, 2)))) 
				- exp(0.5 * ((Math.cos(2 * x1 * Math.PI) + (Math.cos(2 * x2 * Math.PI))))) 
				+ Math.E + 20;
		
		return result;
	}
}
