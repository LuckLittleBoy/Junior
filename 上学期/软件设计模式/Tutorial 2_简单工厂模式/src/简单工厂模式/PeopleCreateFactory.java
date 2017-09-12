package 简单工厂模式;

public class PeopleCreateFactory {

	public static AbstractPeople getPeopleCreate(String type){
		
		if(type.equals("M")){
			return new ManPeople();
		}
		
		else if(type.equals("W")){
			return new WomanPeople();
		}
		
		else if (type.equals("R")){
			return new RobotPeople();
		}
		else{
			
			System.out.println("请输入正确的选择！");
		}
		return null;
	}
	
}
