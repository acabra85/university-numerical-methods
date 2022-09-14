package controlador.methods;

import functions.RealFunction;

public class BisectionMethod extends IterativeRootFindingAlgorithm {
	public BisectionMethod() {
		super();
		this.parameters = new double[3];
	}

	public BisectionMethod(RealFunction rf1) {
		super(rf1);
	}

	public BisectionMethod(RealFunction rf1, double[] params) {
		super(rf1, params);
	}

	public BisectionMethod(RealFunction rf1, double[] params, double tol1) {
		super(rf1, params, tol1);
	}

	public String iterateMethod(int numIterations) {
		int i =0;
		for ( i= 0; (i < numIterations && !toleranceReached()); i++) {
			this.parameters = applyMethod(parameters);			
		}
		return " c: " +parameters[2]+" iteraciones: "+i;
		//System.out.println("a: " +parameters[0]+" b: " +parameters[1]+" c: " +parameters[2]+" iteraciones: "+i);
	}
	
	public double[] applyMethod(double[] params) {
		double a = params[0], b = params[1], c = 0.0d, fc = 0.0d, fa = 0.0d, fb = 0.0d;
		double[] rtnP = new double[3];
		c = (b + a) / 2;
		fa = rf.evaluate(a);
		fb = rf.evaluate(b);
		fc = rf.evaluate(c);
		//System.out.println("fa:"+fa+" fb:"+fb+ " fc:" + fc);
		if ((fa * fc) < 0)
			b = c;
		else if ((fb * fc) < 0)
			a = c;
		//System.out.println("a:"+a+" b:"+b+ " c:" + c);
		rtnP[0] = a;
		rtnP[1] = b;
		rtnP[2] = c;
		return rtnP;
	}
}
