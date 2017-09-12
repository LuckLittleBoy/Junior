package packages;

public abstract class AbstractFile {

	public abstract void operation();
	public abstract void add(AbstractFile f);
	public abstract void remove(AbstractFile f);
	public abstract AbstractFile getChild(int i);
}
