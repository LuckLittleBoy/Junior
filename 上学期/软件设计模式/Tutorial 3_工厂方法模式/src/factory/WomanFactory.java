package factory;

public class WomanFactory extends PeopleFactory {

	@Override
	public People CreatePeople() {
		// TODO 自动生成的方法存根
		return new WomanPeople();
	}

}
