package packages;

public class Client {

	public static void main(String args[])
	{
		Che che;
		Road road;
		
		che = (Che)XMLUtilChe.getBean("che");
		road = (Road)XMLUtilChe.getBean("road");
		
		che.setRoad(road);
		che.drive("ÐÐÊ»");
	}
}
