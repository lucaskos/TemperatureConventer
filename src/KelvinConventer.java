import MyResults;
import strategies.Strategy;

public class KelvinConventer implements Strategy {

	@Override
	public MyResults convert(double number) {
		double celsius = (number - 273.15);
		double fahrenheit = ((celsius - 32) * 5 / 9);
		return new MyResults(celsius, (int) number, fahrenheit);
	}

}
