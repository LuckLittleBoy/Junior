package com.cms.student.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.cms.model.Student;
import com.cms.student.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport
{
	private StudentService stuService;
	
	public StudentService getStuService()
	{
		return stuService;
	}
	public void setStuService(StudentService stuService)
	{
		this.stuService = stuService;
	}

	public String stuexecute() throws Exception
	{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter(); 
        
		List<Student> list = stuService.getStudents();
		JSONArray msg=JSONArray.fromObject(list);
		out.println(msg.toString());
		out.flush();
		out.close();
		return null;
	}
	
}
