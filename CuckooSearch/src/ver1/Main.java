package ver1;

import java.util.Arrays;

public class Main {
	
	static int population = 15;
	static Function nest[] = new Function[population];
	static int maxGeneration = 50000000;
	static double range = 512;
	static double discoverPro = 0.25;
	static double alpha = 1;
	static int printGeneration = 10000;
	static int cutGeneration = 100000000;
	
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
		
		double next = current + (alpha * Math.pow(3, (0 - lamda)));
		return next;
	}
	
	static void laying(int generation) {
		int index = (int)Math.random() * (population - 1) + 1;
		Function cuckoo = new Function(levy(nest[index].getX(),generation), levy(nest[index].getY(),generation));
		if(nest[index].getFitness() > cuckoo.getFitness()) {
			nest[index] = new Function(cuckoo.getX(), cuckoo.getY());
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
		int history = 0;
		double temp = 20;
		while(generation < maxGeneration && history < cutGeneration) {
			laying(generation);
			sorting(nest);
			if(generation % printGeneration == 0) {
				System.out.println("Generation " + generation);
				print(nest[0]);
			}
			generation++;
			
			if(temp == nest[0].getFitness()) {
				history++;
			}else {
				history = 0;
				temp = nest[0].getFitness();
			}
			
			
		}
	}
	
	static void print(Function f) {
		System.out.println("X : " + String.format("%.10f", f.getX()) + " Y : " + String.format("%.10f", f.getY()) + " Fitness : " + String.format("%.10f", f.getFitness()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialized();
		generation();
		System.out.println("Satisfied Fitness : " + String.format("%.10f", nest[0].getFitness()));
		
	}

}
