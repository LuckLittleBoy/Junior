package packages;

public abstract class ComputerBuilder {

    protected Computer computer = new Computer();
	
	public abstract void buildCPU();
	public abstract void buildARM();
	public abstract void buildHD();
	public abstract void buildMB();
	public Computer getComputer()
	{
		return this.computer;
	}
}
