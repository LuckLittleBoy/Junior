package packages;

public class Computer {

	private String CPU;
	private String ARM;
	private String HD;
	private String MB;
	
	public void setCPU(String cpu)
	{
		this.CPU=cpu;
	}
	public void setARM(String arm)
	{
		this.ARM=arm;
	}
	public void setHD(String hd)
	{
		this.HD=hd;
	}
	public void setMB(String mb)
	{
		this.MB=mb;
	}
	
	public String getCPU()
	{
		return(this.CPU);
	}
	public String getARM()
	{
		return(this.ARM);
	}
	public String getHD()
	{
		return(this.HD);
	}
	public String getMB()
	{
		return(this.MB);
	}
}
