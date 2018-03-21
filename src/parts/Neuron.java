package parts;

public class Neuron {
	
	
	public double bias;
	public double[] weights;
	
	public Neuron(int numInputs) {
		
		weights = new double[numInputs];
		this.bias = 0.01;
		double weightFraction = (1/(Math.sqrt(numInputs)));
		
		for(int i=0; i< numInputs; i++) {
			
			weights[i] = (Math.random() * (Math.pow(weightFraction, 2) - weightFraction) - weightFraction);
			
		}
		
	}
	
	public void printWeights() {
		for(double w : weights) {
			System.out.println(w);
		}
	}
	
	public double activation(double sum) {
		double sigmoid = 0;
		sigmoid = Math.exp(sum) / (Math.exp(sum) + 1);
		return sigmoid;
	}
	
	public double fire( double[] inputs ) {
		double sum = 0;
		for(int i=0; i<weights.length; i++) {
			sum += bias + weights[i] * inputs[i];
		}
		return activation(sum);
	}
}
