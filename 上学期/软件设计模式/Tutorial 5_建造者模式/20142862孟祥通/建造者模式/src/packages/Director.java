package packages;

public class Director {

	private ComputerBuilder cb;
	
	public void setComputerBuilder(ComputerBuilder cb)
	{
		this.cb=cb;
	}
	
	public Computer construct()
	{
		cb.buildARM();
		cb.buildCPU();
		cb.buildHD();
		cb.buildMB();
		
		return cb.getComputer();
	}
}
