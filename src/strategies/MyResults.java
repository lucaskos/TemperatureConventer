package strategies;

public final class MyResults {
	private final double celsius;
	private final int kelvin;
	private final double fahrenheit;
	
	public MyResults(double celsius, int kelvin, double fahrenheit) {
		super();
		this.celsius = celsius;
		this.kelvin = kelvin;
		this.fahrenheit = fahrenheit;
	}
	public int getCelsius() {
		return (int) Math.round(celsius);
	}
	public int getKelvin() {
		return (int) Math.round(kelvin);
	}
	public int getFahrenheit() {
		return (int) Math.round(fahrenheit);
	}
	

}
