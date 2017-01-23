
final class MyResults {
	private final double celsius;
	private final int kelvin;
	private final double fahrenheit;
	
	public MyResults(double number, int kelvin, double fahrenheit) {
		this.celsius = number;
		this.kelvin = kelvin;
		this.fahrenheit = fahrenheit;
	}

	public int getCelsius() {
		return (int) celsius;
	}

	public int getKelvin() {
		return kelvin;
	}

	public double getFahrenheit() {
		return fahrenheit;
	}

}
