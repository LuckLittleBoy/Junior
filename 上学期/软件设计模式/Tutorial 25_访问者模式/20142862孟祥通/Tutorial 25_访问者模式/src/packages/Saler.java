package packages;
public class Saler extends Visitor
{
	public void visit(Apple apple)
	{
		System.out.println("收银员" + name + "给苹果过秤，然后计算其价格。");
	}
	
	public void visit(Book book)
	{
		System.out.println("收银员" + name + "直接计算书的价格。");
	}

	@Override
	public void visit(Apple apple, Book book) {
		// TODO 自动生成的方法存根
		System.out.println("收银员" + name + "计算价格。");
	}
}