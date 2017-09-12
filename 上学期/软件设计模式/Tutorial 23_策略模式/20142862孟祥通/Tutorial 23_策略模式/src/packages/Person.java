package packages;

public class Person {

	private TravelStrategy strategy;
	
	public void setStrategy(TravelStrategy strategy)
	{
		this.strategy = strategy;
	}
	public void travel()
	{
		strategy.travel();
	}
}
