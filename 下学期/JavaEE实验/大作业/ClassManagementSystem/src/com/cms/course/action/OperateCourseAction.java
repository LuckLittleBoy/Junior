package com.cms.course.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.cms.course.service.CourseService;
import com.cms.model.Course;
import com.opensymphony.xwork2.ActionSupport;

public class OperateCourseAction extends ActionSupport
{
	private String kno;
	private String kname;
	private String kproprety;
	private Integer kcredit;
	private int operateid;
	private CourseService courseService;
	public CourseService getCourseService()
	{
		return courseService;
	}
	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}
	public String getKno()
	{
		return kno;
	}
	public void setKno(String kno)
	{
		this.kno = kno;
	}
	public String getKname()
	{
		return kname;
	}
	public void setKname(String kname)
	{
		this.kname = kname;
	}
	public String getKproprety()
	{
		return kproprety;
	}
	public void setKproprety(String kproprety)
	{
		this.kproprety = kproprety;
	}
	public Integer getKcredit()
	{
		return kcredit;
	}
	public void setKcredit(Integer kcredit)
	{
		this.kcredit = kcredit;
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
		ServletActionContext.getRequest().getSession().setAttribute("child", "3");
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter();
		if(operateid==0)
		{
			courseService.deleteCourse(kno);
		}
		else if(operateid==1)
		{
			courseService.editCourse(kno, kname, kproprety, kcredit);
		}
		else if(operateid==2)
		{
			ServletActionContext.getRequest().getSession().setAttribute("child", "6");
			Course course=courseService.findCourseByKno(kno);
			JSONArray msg=JSONArray.fromObject(course);
			out.println(msg.toString());
			out.flush();
			out.close();
			return SUCCESS;
		}
		else if(operateid==3)
		{
			courseService.addCourse(kno, kname, kproprety, kcredit);
		}
		else
		{
			return ERROR;
		}
		return SUCCESS;
	}
}
