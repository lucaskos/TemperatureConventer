
public class Context {
	
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public MyResults executeStrategy(double number) {
		return strategy.convert(number);
	}

}
