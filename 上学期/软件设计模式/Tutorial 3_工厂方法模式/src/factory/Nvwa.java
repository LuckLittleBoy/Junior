package factory;

public class Nvwa {
	public static void main(String args[]){
		try{
			People abpeople;
			PeopleFactory pfactory = (PeopleFactory)XMLPeople.getBean();
			abpeople = pfactory.CreatePeople();
			abpeople.people();
	
		}
		
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}
}