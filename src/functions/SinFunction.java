package functions;
public class SinFunction extends RealFunction {

	public SinFunction() {
		super();
	}

	@Override
	public double evaluate(double x) {
		return Math.sin(x);
	}

	@Override
	public double derivate(double x) {
		return Math.cos(x);
	}

}
