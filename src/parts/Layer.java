package parts;

public class Layer {
	
	public boolean isInputLayer;
	public Neuron[] neurons;
	
	
	public Layer(int numInputs, int numNeurons, boolean isInputLayer) {
		
		this.isInputLayer = isInputLayer;
		
		neurons = new Neuron[numNeurons];
		for(int i=0; i < neurons.length; i++) {
			neurons[i] = new Neuron(numInputs);
		}
		
	}
	
	public double[] fire(double[] inputs) {
		double[] outputs = new double[inputs.length];
		if(isInputLayer) {
			for(int i=0; i<neurons.length; i++) {
				outputs[i] = neurons[i].fire(new double[] { inputs[i] });
			}
		} else {
			for(int i=0; i<neurons.length; i++) {
				outputs[i] = neurons[i].fire(inputs);
			}
		}
		
		
		return outputs; 
	}
}
