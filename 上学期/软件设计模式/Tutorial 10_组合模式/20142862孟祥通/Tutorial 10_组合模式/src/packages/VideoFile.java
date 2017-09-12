package packages;

public class VideoFile extends AbstractFile{

	@Override
	public void operation() {
		// TODO 自动生成的方法存根
		System.out.println("一个媒体文件");
	}

	@Override
	public void add(AbstractFile f) {
		// TODO 自动生成的方法存根
		System.out.println("媒体无法添加子节点");
	}

	@Override
	public void remove(AbstractFile f) {
		// TODO 自动生成的方法存根
		System.out.println("媒体无法删除子节点");
	}

	@Override
	public AbstractFile getChild(int i) {
		// TODO 自动生成的方法存根
		return null;
	}

}
