package ver1;

import java.util.Arrays;

public class Main {
	
	static int population = 15;
	static Function nest[] = new Function[population];
	static int maxGeneration = 500000000;
	static double range = 32.768;
	static double discoverPro = 0.25;
	static double alpha = 1;
	
	static double randomSet(double range) {
		return (Math.random() * range * 2) - range;
	}
	
	static void initialized() {
		for(int i = 0; i < population; i++) {
			nest[i] = new Function(randomSet(range), randomSet(range));
		}
	}
	
	static double levy(double current,int generation) {
		double lamda;
		do{
			lamda = (Math.random() * 2.1) + 1;
		}while(lamda > 1 && lamda <=3);
		
		double next = current + (alpha * Math.pow(generation, lamda));
		return next;
	}
	
	static void laying(int generation) {
		int index = (int)Math.random() * (population - 1) + 1;
		Function cuckoo = new Function(levy(nest[index].getX1(),generation), levy(nest[index].getX2(),generation));
		if(nest[index].getFitness() > cuckoo.getFitness()) {
			nest[index] = new Function(cuckoo.getX1(), cuckoo.getX2());
		}
		discover(index);
	}
	
	static void discover(int i) {
		if(Math.random() > discoverPro) {
			nest[i] = new Function(randomSet(range), randomSet(range));
		}
	}
	
	static void sorting(Function nest[]) {
		Arrays.sort(nest);
	}
	
	static void generation() {
		int generation = 0;
		while(generation < maxGeneration) {
			laying(generation);
			sorting(nest);
			generation++;
			
			if(generation % (maxGeneration/100) == 0) {
				System.out.println("Generation " + generation);
				print(nest[0]);
			}
		}
	}
	
	static void print(Function f) {
		System.out.println("x1 : " + String.format("%.10f", f.getX1()) + " x2 : " + String.format("%.10f", f.getX2()) + " fitness : " + String.format("%.10f", f.getFitness()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialized();
		generation();
		System.out.println("Fitness : " + nest[0].getFitness());
		
	}

}
