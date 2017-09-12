package com.cms.student.action;

import org.apache.struts2.ServletActionContext;

import com.cms.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private String sno;
	private String pwd;
	private StudentService stuService;
	public String getSno()
	{
		return sno;
	}
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
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
		if(stuService.UserLogin(sno, pwd))
		{
			ServletActionContext.getRequest().getSession().setAttribute("child", "1");
			return SUCCESS;
		}
		return ERROR;
	}
}
