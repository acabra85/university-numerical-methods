package controlador.methods;

import functions.RealFunction;


public class NewtonMethod extends IterativeRootFindingAlgorithm {
	public NewtonMethod() {
		super();
	}

	public NewtonMethod(RealFunction rf1) {
		super(rf1);
	}

	public NewtonMethod(RealFunction rf1, double[] params) {
		super(rf1, params);
	}

	public NewtonMethod(RealFunction rf1, double[] params, double tol1) {
		super(rf1, params, tol1);
	}
	
	public String iterateMethod(int numIterations) {
		int i =0;
		for ( i= 0; (i < numIterations) && !toleranceReached(); i++) {
			this.parameters = applyMethod(parameters);			
		}
		return "a: " +parameters[0]+" iteraciones: "+i;
	} 
	
	@Override
	public boolean toleranceReached() {
		return Math.abs(rf.evaluate(this.parameters[0])) < this.tolerance ; 
	}
	
	public double[] applyMethod(double[] params) {
		double p0 = params[0], p1 = 0.0d;
		double[] rtnP = new double[3];
		p1 = p0 - (rf.evaluate(p0) / rf.derivate(p0));
		rtnP[0] = p1;
		return rtnP;
	}
}
