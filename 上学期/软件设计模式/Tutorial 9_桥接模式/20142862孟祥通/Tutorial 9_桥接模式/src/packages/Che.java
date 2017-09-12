package packages;

public abstract class Che {

	protected Road road;
	
	public void setRoad(Road road)
	{
		this.road=road;
	}
	
	public abstract void drive(String name);
}
