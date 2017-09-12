package packages;

public class Client {

	public static void main(String args[])
	{
		Person person = new Person();
		TravelStrategy strategy1,strategy2,strategy3;
		System.out.println("第一次-----------------------");
		strategy1 = new AirplaneStrategy();
		person.setStrategy(strategy1);
		strategy1.travel();
		System.out.println("第二次-----------------------");
		strategy2 = new BicycleStrategy();
		person.setStrategy(strategy2);
		strategy2.travel();
		System.out.println("第三次-----------------------");
		strategy3 = new TrainStrategy();
		person.setStrategy(strategy3);
		strategy3.travel();
	}
}
