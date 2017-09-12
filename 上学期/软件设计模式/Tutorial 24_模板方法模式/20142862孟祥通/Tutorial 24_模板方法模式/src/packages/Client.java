package packages;

public class Client {

	public static void main(String args[])
	{
		DBMethod db;
		db = new Oracle();
		db.process();
		System.out.println("-----------------------------------");
		db = new SQLServer();
		db.process();
	}
}
