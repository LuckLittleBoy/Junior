package com.cms.course.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.cms.course.service.CourseService;
import com.cms.model.Course;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport
{
	private CourseService courseService;

	public CourseService getCourseService()
	{
		return courseService;
	}

	public void setCourseService(CourseService courseService)
	{
		this.courseService = courseService;
	}

	public String courexecute() throws Exception
	{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter(); 
        
		List<Course> list = courseService.getCourses();
		JSONArray msg=JSONArray.fromObject(list);
		out.println(msg.toString());
		out.flush();
		out.close();
		return null;
	}
}
