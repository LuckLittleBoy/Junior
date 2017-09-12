package com.cms.student.action;

import com.cms.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport
{
	private String sno;
	private String sname;
	private String ssex;
	private String sbirth;
	private String spwd;
	private String stel;
	private String saddress;
	private String cno;
	
	private StudentService stuService;
	public StudentService getStuService()
	{
		return stuService;
	}
	public void setStuService(StudentService stuService)
	{
		this.stuService = stuService;
	}
	public String getSno()
	{
		return sno;
	}
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	public String getSsex()
	{
		return ssex;
	}
	public void setSsex(String ssex)
	{
		this.ssex = ssex;
	}
	public String getSbirth()
	{
		return sbirth;
	}
	public void setSbirth(String sbirth)
	{
		this.sbirth = sbirth;
	}
	public String getSpwd()
	{
		return spwd;
	}
	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
	}
	public String getStel()
	{
		return stel;
	}
	public void setStel(String stel)
	{
		this.stel = stel;
	}
	public String getSaddress()
	{
		return saddress;
	}
	public void setSaddress(String saddress)
	{
		this.saddress = saddress;
	}
	public String getCno()
	{
		return cno;
	}
	public void setCno(String cno)
	{
		this.cno = cno;
	}
	public String execute() throws Exception
	{
		boolean flag=stuService.UserRegister(sno, sname, ssex, sbirth, spwd, stel, saddress, cno);
		if(flag)
			return SUCCESS;
		return ERROR;
	}
	
}
