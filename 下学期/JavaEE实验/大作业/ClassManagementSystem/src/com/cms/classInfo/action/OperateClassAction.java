package com.cms.classInfo.action;

import org.apache.struts2.ServletActionContext;

import com.cms.classInfo.service.ClassInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class OperateClassAction extends ActionSupport
{
	private String cno;
	private String cname;
	private int operateid;
	private ClassInfoService classService;
	public ClassInfoService getClassService()
	{
		return classService;
	}
	public void setClassService(ClassInfoService classService)
	{
		this.classService = classService;
	}
	public String getCno()
	{
		return cno;
	}
	public void setCno(String cno)
	{
		this.cno = cno;
	}
	
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
	}
	public int getOperateid()
	{
		return operateid;
	}
	public void setOperateid(int operateid)
	{
		this.operateid = operateid;
	}

	public String execute() throws Exception
	{
		ServletActionContext.getRequest().getSession().setAttribute("child", "1");
		if(operateid==0)
		{
			classService.deleteClassInfo(cno);
		}
		else if(operateid==1)
		{
			classService.editClassInfo(cno,cname);
		}
		else if(operateid==2)
		{
			classService.findClassByCno(cno);
		}
		else if(operateid==3)
		{
			classService.addClassInfo(cno,cname);
		}
		else
		{
			return ERROR;
		}
		return SUCCESS;
	}
}
