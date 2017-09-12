package 简单工厂模式;

import java.util.Scanner;

public class Nvwa {
	public static void main(String args[]){
		
		String type = null;
		Scanner sc = new Scanner(System.in);
		type = sc.next();
		
		try{
			AbstractPeople abpeople;
			abpeople = PeopleCreateFactory.getPeopleCreate(type);
			abpeople.people();
			sc.close();
		}
		
		catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}
}
