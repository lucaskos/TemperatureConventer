package strategies;

public class CelsiusConventer implements TemperatureStrategy {

	@Override
	public int convert(int temperature) {
		float fahrenheit = (float) (Float.valueOf(temperature) * 1.8 + 32);
		//TODO insert body of the method
		return temperature;
	}

}
