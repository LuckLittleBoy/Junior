package factory;

public class RobotFactory extends PeopleFactory {

	@Override
	public People CreatePeople() {
		// TODO 自动生成的方法存根
		return new RobotPeople();
	}

}
