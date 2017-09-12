package packages;

public class Client
{
	public static void main(String args[])
	{
		Account account=new Account("ÕÅÈý",100);
		account.deposit(20);
		System.out.println("--------------------------------------");
		account.withdraw(40);
		System.out.println("--------------------------------------");
		account.withdraw(1200);
		System.out.println("--------------------------------------");
		account.withdraw(400);
		System.out.println("--------------------------------------");
		account.deposit(800);
		System.out.println("--------------------------------------");
		account.deposit(200);
		System.out.println("--------------------------------------");
		account.withdraw(400);
		System.out.println("--------------------------------------");
		account.withdraw(400);
		System.out.println("--------------------------------------");
	}
}