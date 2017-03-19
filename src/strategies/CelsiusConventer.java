package strategies;

public class CelsiusConventer implements TemperatureStrategy {

	public MyResults convert(double number) {
		int kelvin = (int) Math.round(number + 273.15);
		double fahrenheit = number * 1.8 + 32; 
		return new MyResults(number, kelvin, fahrenheit);
	}

}
