
public class FahrenheitConventer implements Strategy {
	public MyResults convert(double number) {
		int celsius = (int) ((number - 32) * 5 / 9);
		int kelvin = (int) (celsius + 273.15);
		return new MyResults(celsius, kelvin, number);
		
	}

}
