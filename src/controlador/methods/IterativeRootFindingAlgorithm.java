package controlador.methods;

import functions.RealFunction;

public abstract class IterativeRootFindingAlgorithm {
	protected RealFunction rf;
	protected double[] parameters;
	protected double tolerance;

	public IterativeRootFindingAlgorithm() {
		this.parameters = new double[3];
	}

	public IterativeRootFindingAlgorithm(RealFunction rf1) {
		this.rf = rf1;
		this.parameters = new double[3];
		this.tolerance = 0.0d;
	}

	public IterativeRootFindingAlgorithm(RealFunction rf1, double[] params) {
		this.rf = rf1;
		this.parameters = params;
		this.tolerance = 0.0d;
	}

	public IterativeRootFindingAlgorithm(RealFunction rf1, double[] params,	double tol1) {
		this.rf = rf1;
		this.parameters = params;
		this.tolerance = tol1;
	}

	public RealFunction getFunction() {
		return rf;
	}

	public double[] getParameters() {
		return this.parameters;
	}

	public double getTolerace() {
		return this.tolerance;
	}

	public void setFunction(RealFunction rf1) {
		this.rf = rf1;
	}

	public void setParameters(double[] params) {
		this.parameters = params;
	}

	public void setTolerance(double tol) {
		this.tolerance = tol;
	}

	public String iterateMethod(int numIterations) {
		int i = 0;
		for (i = 0; i < numIterations && !toleranceReached(); i++) {
			parameters = applyMethod(parameters);
		}
		return "a: " +parameters[0]+" b: " +parameters[1]+" itera:" +i;
	}

	public abstract double[] applyMethod(double[] params);

	public boolean toleranceReached() {
		return Math.abs(this.parameters[0] - this.parameters[1]) < this.tolerance;
	}
}
