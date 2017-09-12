package packages;
public class Customer extends Visitor
{
	public void visit(Apple apple)
	{
		System.out.println("顾客" + name + "选苹果。");
	}
	
	public void visit(Book book)
	{
		System.out.println("顾客" + name + "买书。");
	}

	@Override
	public void visit(Apple apple, Book book) {
		// TODO 自动生成的方法存根
		System.out.println("顾客" + name + "买书和选苹果。");
	}
}