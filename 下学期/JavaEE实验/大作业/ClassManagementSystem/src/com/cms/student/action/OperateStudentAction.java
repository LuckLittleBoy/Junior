package com.cms.student.action;

import org.apache.struts2.ServletActionContext;

import com.cms.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class OperateStudentAction extends ActionSupport
{
	private String sno;
	private String sname;
	private String ssex;
	private String sbirth;
	private String spwd;
	private String stel;
	private String saddress;
	private String cno;
	private int operateid;
	private StudentService stuService;
	public String getSno()
	{
		return sno;
	}
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	public String getCno()
	{
		return cno;
	}
	public void setCno(String cno)
	{
		this.cno = cno;
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
	public int getOperateid()
	{
		return operateid;
	}
	public void setOperateid(int operateid)
	{
		this.operateid = operateid;
	}
	public StudentService getStuService()
	{
		return stuService;
	}
	public void setStuService(StudentService stuService)
	{
		this.stuService = stuService;
	}

	public String execute() throws Exception
	{
		ServletActionContext.getRequest().getSession().setAttribute("child", "2");
		if(operateid==0)
		{
			stuService.deleteStudent(sno);
		}
		else if(operateid==1)
		{
			stuService.editStudent(sno, sname, ssex, sbirth, spwd, stel, saddress, cno);
		}
		else if(operateid==2)
		{
			stuService.findStudentBySno(sno);
		}
		else if(operateid==3)
		{
			stuService.UserRegister(sno, sname, ssex, sbirth, spwd, stel, saddress, cno);
		}
		else
		{
			return ERROR;
		}
		return SUCCESS;
	}
}
