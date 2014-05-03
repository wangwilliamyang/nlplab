package edu.cmu.ml.praprolog.learn;

public class LinearWeightingScheme extends WeightingScheme {

	@Override
	public double edgeWeightFunction(double sum) {
		return sum;
	}

	@Override
	public double derivEdgeWeight(double weight) {
		return weight;
	}

	@Override
	public double defaultWeight() {
		return 1.0;
	}

	@Override
	public String toString() { return "linear"; }
}
