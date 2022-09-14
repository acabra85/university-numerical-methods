package functions;
public class CosFunction extends RealFunction {

	@Override
	public double evaluate(double x) {
		return Math.cos(x);
		//return Math.sqrt(x)-Math.cos(x);
	}

	@Override
	public double derivate(double x) {
		return -Math.sin(x);
	}

}
