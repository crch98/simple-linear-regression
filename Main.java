import ia_algorithms.LinearRegression;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Give one argument to the program.");
			System.exit(0);
		}

		LinearRegression ln = new LinearRegression();
		double learning_rate = 0.001;
		int num_epoch = 50;
		double[][] dataset = {{1, 1}, {2, 3}, {4, 3}, {3, 2}, {5, 5}};

		ln.train(dataset, learning_rate, num_epoch);

		System.out.println("Regression equation:");
		System.out.println("y_p = " + ln.getBeta_0() + " + " +
			ln.getBeta_1() + " * X");

		double target = Integer.parseInt(args[0]); 

		System.out.println("Predicted value of " + target + ": " +
			ln.predict(target));
	}

}

