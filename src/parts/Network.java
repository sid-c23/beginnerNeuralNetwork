package parts;

public class Network implements Cloneable{
	public Layer[] layers;
	
	//copy constructor
	public Network(Network copy) {
		this.layers = copy.layers;
	}
	
	public Network(int numInputs, int numOutputs, int numHiddenLayers, int hiddenLayerWidth) {
		layers = new Layer[numHiddenLayers + 2];
		layers[0] = new Layer(1, numInputs, true);
		for(int i=1; i<numHiddenLayers+1; i++) {
			layers[i] = new Layer(numInputs, hiddenLayerWidth, false);
		}
		layers[layers.length-1] = new Layer(numOutputs, numOutputs, false);
	}
	public double[] feedForward(double[] inputs) {
		
		double[] output = layers[0].fire(inputs);
		
		
		for(int i=1; i<layers.length; i++) {
			output = layers[i].fire(output);
		}
		return output;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
