package packages;

public class Baler extends Visitor
{
	public void visit(Apple apple)
	{
		System.out.println("打包员" + name + "给苹果打包。");
	}
	
	public void visit(Book book)
	{
		System.out.println("打包员" + name + "给书打包。");
	}

	@Override
	public void visit(Apple apple, Book book) {
		// TODO 自动生成的方法存根
		System.out.println("打包员" + name + "给书和苹果打包。");
	}
}
