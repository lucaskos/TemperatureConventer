package strategies;

public class KelvinConventer implements TemperatureStrategy {

	public MyResults convert(double number) {
		double celsius = (number - 273.15);
		double fahrenheit = ((celsius - 32) * 5 / 9);
		return new MyResults(celsius, (int) number, fahrenheit);
	}

}
