package ia_algorithms;

public class LinearRegression {

	private double beta_0;
	private double beta_1;

	public LinearRegression() {
		beta_0 = 0.0;
		beta_1 = 0.0;
	}

	public double predict(double x) {
		return (beta_1 * x) + beta_0;
	}

	private void gradient_descent(double[][] dataset, double alpha, int epoch) {
		int X_POSITION = 0;
		int Y_POSITION = 1;

		for (int i = 0; i < epoch; i++) {
			for (int j = 0; j < dataset.length; j++) {
				var y_p = predict(dataset[j][X_POSITION]);
				var error = y_p - dataset[j][Y_POSITION];
				beta_0 = beta_0 - (error * alpha);
				beta_1 = beta_1 - (error * alpha * dataset[j][X_POSITION]);
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


