package packages;

public class TaiComputerBuilder extends ComputerBuilder{

	public void buildCPU()
	{
		computer.setCPU("一个台式cpu");
	}
	public void buildARM()
	{
		computer.setARM("一个台式arm");
	}
	public void buildHD()
	{
		computer.setHD("一个台式hd");
	}
	public void buildMB()
	{
		computer.setMB("一个台式mb");
	}
}
