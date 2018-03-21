package test;
import parts.*;
public class Test {
	public static void main(String[] args) {
		
		//GOAL: to be able to take an average of a data set
		
		
		double[] inputs = {1, 2, 3, 4, 5, 6, 7,  8, 9, 10};
		Network network = new Network(10, 2, 2, 5);
		double[] outputs = network.feedForward(inputs);
		for(double o : outputs) {
			System.out.println(o);
		}
	}
	
	
	public static Network mutate(Network n) throws CloneNotSupportedException {
		Network copy = (Network) n.clone();
		for(Layer l : copy.layers) {
			for(int i=0; i<l.neurons.length; i++) {
				l.neurons[i].bias *= (Math.random() * 0.002 - 0.001);
				for(int k=0; k<l.neurons[i].weights.length; k++) {
					l.neurons[i].weights[k] *= (Math.random() * 0.002 - 0.001);
				}
			}
		}
		
		return copy;
	}
	
	public static double mse(Network n, double[][] inputs, double[][] outputs) {
		
		return 2.0; //CHANGE!!!
	}
	
}
