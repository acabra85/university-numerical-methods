package functions;

public class FuncionPolinomial extends RealFunction {
	
	final double[] coefficients;
	
	public FuncionPolinomial(double[] coefficients) {
		super();
		this.coefficients = coefficients;
	}

	@Override
	public double evaluate(double x) {
		//return Math.pow(x, 2)-6;
		//double val1 = 2/3;
		//double val2 = 3/2;
		//return Math.sin(x) - (val1)*Math.pow(x, val2);
		//return Math.cos(x) - Math.pow(x, 0.5);
		//return Math.pow(Math.E,(2-x))*(Math.pow(x,2)-2*x+0.1)+0.081*x;
		//return Math.pow(x,4)-3*Math.pow(x,3)+Math.pow(x,2)+x-1;
		//return Math.sqrt(x)-Math.cos(x);
		//return 3*(x+1)*(x-0.5)*(x-1);
		//return 2*x*Math.cos(2*x) - Math.pow((x+1), 2);
		//return Math.pow(x, 2) - 6;
		//return Math.pow(Math.E,x) - Math.pow(2, -x) + 2*Math.cos(x) - 6;
		//return Math.log(x-1) + Math.cos(x-1);
		//return  Math.sin(x) - Math.pow(Math.E,x);
		//return Math.pow((x-2), 2) - Math.log(x);
		//return 230*Math.pow(x, 4) +18*Math.pow(x, 3) + 9*Math.pow(x, 2)-221*Math.pow(x, 1)-9;
		//return (155.55/(x+Math.sqrt(x)))- Math.sqrt(20-x)-(20-x);
		return Math.tan(Math.PI*x)-6;
	}

	@Override
	public double derivate(double x) {
		//System.out.println(2*x);
		//return 2*x;
		//return Math.pow(Math.E,x) + Math.pow(2, -x)*Math.log(2) - 2*Math.sin(x);
		//return (1/(x-1)) - Math.sin(x-1);
		//return Math.cos(x) - (1/x);
		//return 2*(x-2) - (1/x);
		//return 920*Math.pow(x, 3) +54*Math.pow(x, 2) + 18*Math.pow(x, 1)-221;
		return Math.PI/Math.pow((Math.cos(Math.PI*x)), 2);
	}

}
