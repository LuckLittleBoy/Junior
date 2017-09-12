package com.cms.grade.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.cms.grade.service.GradeService;
import com.cms.model.Grade;
import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport
{
	private GradeService gradeService;

	public GradeService getGradeService()
	{
		return gradeService;
	}

	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	public String gradeexecute() throws Exception
	{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter(); 
        
		List<Grade> list = gradeService.getGrade();
		JSONArray msg=JSONArray.fromObject(list);
		out.println(msg.toString());
		out.flush();
		out.close();
		return null;
	}
}
