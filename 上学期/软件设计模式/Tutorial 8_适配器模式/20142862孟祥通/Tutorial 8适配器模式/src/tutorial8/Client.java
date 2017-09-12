package tutorial8;

public class Client {
	
	public static void main(String args[])
	{
		ConcreteDog dog = new ConcreteDog();
		ConcreteCat cat = new ConcreteCat();
		Adapter adapter = new Adapter();
		adapter.setCat(cat);
		adapter.setDog(dog);
		adapter.wang();
		adapter.mouse();
	}
}
