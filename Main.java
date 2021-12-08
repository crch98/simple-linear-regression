import ia_algorithms.LinearRegression;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Give one argument to the program.");
			System.exit(0);
		}

		LinearRegression ln = new LinearRegression();
		double learning_rate = 0.001;
		int num_epoch = 13100;
		double[][] dataset = {
			{23, 651},  {26, 762},  {30, 856},
			{34, 1063}, {43, 1190}, {48, 1298}, 
			{52, 1421}, {57, 1440}, {58, 1518}
    	};

		ln.train(dataset, learning_rate, num_epoch);

		System.out.println("Regression equation:");
		System.out.println("y_p = " + ln.getBeta_0() + " + " +
			ln.getBeta_1() + " * X");

		double target = Integer.parseInt(args[0]); 

		System.out.println("Predicted value of " + target + ": " +
			ln.predict(target));
	}

}