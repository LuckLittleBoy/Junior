package packages;

import java.util.ArrayList;

public class Folder extends AbstractFile{

	private ArrayList list = new ArrayList();
	@Override
	public void operation() {
		// TODO 自动生成的方法存根
		for(Object obj:list)
		{
			((AbstractFile)obj).operation();
		}
	}

	@Override
	public void add(AbstractFile f) {
		// TODO 自动生成的方法存根
		list.add(f);
		System.out.println("添加成功");
	}

	@Override
	public void remove(AbstractFile f) {
		// TODO 自动生成的方法存根
		list.remove(f);
		System.out.print("删除成功");
	}

	@Override
	public AbstractFile getChild(int i) {
		// TODO 自动生成的方法存根
		return (AbstractFile)list.get(i);
	}

}
