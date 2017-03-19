package strategies;

public class Context {
	private TemperatureStrategy strategy;
	
	public Context(TemperatureStrategy strategy) {
		this.strategy = strategy;
	}
	
	public int executeStrategy(int temperature) {
		return strategy.convert(temperature);
	}
}
