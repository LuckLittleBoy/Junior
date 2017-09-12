package factory;

public class YFactory implements EFactory{

	@Override
	public Man produceMan() {
		// TODO 自动生成的方法存根
		return new YMan();
	}

	@Override
	public Woman produceWoman() {
		// TODO 自动生成的方法存根
		return new YWoman();
	}

}
