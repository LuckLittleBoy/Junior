package tutorial8;

public class Adapter implements Cat,Dog{
	
	private Cat cat;
	private Dog dog;
	@Override
	public void wang() {
		// TODO 自动生成的方法存根
		System.out.println("猫模仿狗：");
		dog.wang();
	}
	@Override
	public void mouse() {
		// TODO 自动生成的方法存根
		System.out.println("狗模仿猫：");
		cat.mouse();
	}
	
	public void setCat(Cat cat)
	{
		this.cat = cat;
	}
	public void setDog(Dog dog)
	{
		this.dog = dog;
	}

}
