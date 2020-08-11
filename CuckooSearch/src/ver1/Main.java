package ver1;

import java.util.Arrays;

public class Main {
	
	int population = 15;
	Function nest[] = new Function[population];
	int maxGeneration = 50000000;
	double range = 5;
	double discoverPro = 0.25;
	double alpha = 1;
	int printGeneration = 1000000000;
	int cutGeneration = 10000000;
	
	int generation = 0;
	
	double randomSet(double range) {
		return (Math.random() * range * 2) - range;
	}
	
	void initialized() {
		for(int i = 0; i < population; i++) {
			nest[i] = new Function(randomSet(range), randomSet(range));
		}
	}
	
	double levy(double current,int generation) {
		double lamda;
		do{
			lamda = (Math.random() * 2.1) + 1;
		}while(lamda > 1 && lamda <=3);
		
		double next = current + (alpha * Math.pow(3, (0 - lamda)));
		return next;
	}
	
	void laying(int generation) {
		int index = (int)Math.random() * (population - 1) + 1;
		Function cuckoo = new Function(levy(nest[index].getX(),generation), levy(nest[index].getY(),generation));
		if(nest[index].getFitness() > cuckoo.getFitness()) {
			nest[index] = new Function(cuckoo.getX(), cuckoo.getY());
		}
		discover(index);
	}
	
	void discover(int i) {
		if(Math.random() > discoverPro) {
			nest[i] = new Function(randomSet(range), randomSet(range));
		}
	}
	
	void sorting(Function nest[]) {
		Arrays.sort(nest);
	}
	
	void generation() {
		generation = 0;
		int history = 0;
		double temp = 20;
		while(generation < maxGeneration && history < cutGeneration) {
			laying(generation);
			sorting(nest);
			if(generation % printGeneration == 0) {
				dataView();
				for (int i = 0; i < dataView().length; i++) {
					for (int j = 0; j < dataView()[0].length; j++) {
						System.out.print(dataView()[i][j] + "\t");
					}
					System.out.println();
				}
				//System.out.println("Generation " + generation);
				//print(nest[0]);
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
	
	void print(Function f) {
		System.out.println("X : " + String.format("%.10f", f.getX()) + " Y : " + String.format("%.10f", f.getY()) + " Fitness : " + String.format("%.10f", f.getFitness()));
	}
	
	double[][] dataView() {
		double[][] a = new double [population][2];
		for (int i = 0; i < a.length; i++) {
			a[i][0] = nest[i].getX();
			a[i][1] = nest[i].getY();
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20; i++) {
			Main main = new Main();
			main.initialized();
			main.generation();
			System.out.println("Last Generation : " + main.generation);
			System.out.println("Satisfied Fitness : " + String.format("%.10f", main.nest[0].getFitness()));
		}
		
	}

}
