package factory;

public class BFactory implements EFactory{

	@Override
	public Man produceMan() {
		// TODO 自动生成的方法存根
		return new BMan();
	}

	@Override
	public Woman produceWoman() {
		// TODO 自动生成的方法存根
		return new BWoman();
	}

}
