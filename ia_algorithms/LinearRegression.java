package ia_algorithms;

public class LinearRegression {

	private double beta_0;
	private double beta_1;

	private static final int X_POSITION = 0;
	private static final int Y_POSITION = 1;

	public LinearRegression() {
		beta_0 = 0.0;
		beta_1 = 0.0;
	}

	public double predict(double x) {
		return (beta_1 * x) + beta_0;
	}

	private double error(double y_i, double y_p) {
		return y_i - y_p;
	}

	private double partialDerivB1(double x, double y, int n) {
		var e = error(y, predict(x));

		return ((double) (-2) / n) * x * e;
	}

	private double partialDerivB0(double x, double y, int n) {
		var e = error(y, predict(x));
 
		return ((double) (-2) / n) * e;
	} 

	private void gradient_descent(double[][] dataset, double alpha, int epoch) {
		int N = dataset.length;

		for (int i = 0; i < epoch; i++) {
			for (int j = 0; j < dataset.length; j++) {
				var x_i = dataset[j][X_POSITION];
				var y_i = dataset[j][Y_POSITION];

				beta_0 -= (alpha * partialDerivB0(x_i, y_i, N));
				beta_1 -= (alpha * partialDerivB1(x_i, y_i, N));
			}
		}
	}

	public double getBeta_0() {
		return beta_0;
	}

	public double getBeta_1() {
		return beta_1;
	}

	public void train(double[][] dataset, double alpha, int epoch) {
		gradient_descent(dataset, alpha, epoch);
	}

}	


