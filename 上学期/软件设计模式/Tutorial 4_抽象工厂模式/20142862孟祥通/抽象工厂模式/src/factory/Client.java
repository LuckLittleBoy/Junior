package factory;

public class Client {
	public static void main(String args[]){
		try
		{
			EFactory factory;
			Man man;
			Woman woman;
			factory = (EFactory)XMLPeople.getBean();
			man = factory.produceMan();
			man.manDisplay();
			woman = factory.produceWoman();
			woman.WomanDisplay();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
