package packages;

public class Client {

	public static void main(String args[])
	{
		AbstractFile obj1,obj2,obj3;
		Folder f1,f2;
		obj1 = new ImageFile();
		obj2 = new TextFile();
		f1 = new Folder();
		f1.add(obj1);
		f1.add(obj2);
		
		obj3 = new VideoFile();
		f2 = new Folder();
		f2.add(obj3);
		
		f2.add(f1);
		
		f2.getChild(0).operation();
	}
}
