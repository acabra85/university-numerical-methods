package controlador.methods;

import functions.RealFunction;


public class SecantMethod extends IterativeRootFindingAlgorithm {

	public SecantMethod(RealFunction rf1) {
		super(rf1);
	}

	public SecantMethod(RealFunction rf1, double[] params) {
		super(rf1, params);
	}

	public SecantMethod(RealFunction rf1, double[] params, double tol1) {
		super(rf1, params, tol1);
	}
	public String iterateMethod(int numIterations) {
		int i =0;
		for ( i= 0; (i < numIterations) && !toleranceReached(); i++) {
			this.parameters = applyMethod(parameters);			
		}
		return "P0:"+parameters[0]+" p1:"+parameters[1]+" iteraciones:"+i;
	} 

	public double[] applyMethod(double[] params) {
		double p0 = params[0], p1 = params[1], p2=0.0d;
		double[] rtnP = new double[3];
		p2 = p1 - (rf.evaluate(p1))*((p1-p0)/(rf.evaluate(p1)-rf.evaluate(p0)));
		rtnP[0]= p1;
		rtnP[1]= p2;		
		return rtnP;
	}

}
