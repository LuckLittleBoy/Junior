package packages;

public class Client {

	public static void main(String args[])
	{
		ComputerBuilder cb = (ComputerBuilder)XMLComputer.getBean();
		
		Director director = new Director();
		
		director.setComputerBuilder(cb);
		
		Computer computer = director.construct();
		
		System.out.println("计算机组成");
		
		System.out.println(computer.getARM());
		System.out.println(computer.getCPU());
		System.out.println(computer.getHD());
		System.out.println(computer.getMB());
		
	}
}
