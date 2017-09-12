package com.cms.student.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cms.classInfo.service.ClassInfoService;
import com.cms.model.ClassInfo;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ClassAction extends ActionSupport
{
	private ClassInfoService classService;

	public ClassInfoService getClassService()
	{
		return classService;
	}


	public void setClassService(ClassInfoService classService)
	{
		this.classService = classService;
	}


	public void classexecute() throws Exception
	{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter(); 
		List<ClassInfo> list = classService.getAllClass();
		String classlist="";
		for(int i=0;i<list.size();i++)
		{
			classlist += list.get(i).getCno() +","+ list.get(i).getCname()+","+list.get(i).getStudents().size()+" ";
		}
        out.println(classlist);
        out.flush();  
        out.close(); 
	}
	
}
