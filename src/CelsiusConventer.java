
public class CelsiusConventer implements Strategy {

	@Override
	public MyResults convert(double number) {
		int kelvin = (int) (number + 273.15);
		double fahrenheit = number * 1.8 + 32; 
		return new MyResults(number, kelvin, fahrenheit);
	}

}
