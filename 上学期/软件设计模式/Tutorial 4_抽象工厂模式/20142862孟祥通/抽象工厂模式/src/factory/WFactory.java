package factory;

public class WFactory implements EFactory{

	@Override
	public Man produceMan() {
		// TODO 自动生成的方法存根
		return new WMan();
	}

	@Override
	public Woman produceWoman() {
		// TODO 自动生成的方法存根
		return new WWoman();
	}

}
