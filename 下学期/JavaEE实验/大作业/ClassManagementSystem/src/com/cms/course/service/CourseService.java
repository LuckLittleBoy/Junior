package com.cms.course.service;

import java.util.List;

import com.cms.course.dao.CourseDao;
import com.cms.model.Course;

public class CourseService
{
	private CourseDao courseDao;
	
	public CourseDao getCourseDao()
	{
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao)
	{
		this.courseDao = courseDao;
	}

	public List<Course> getCourses()
	{
		return courseDao.getCourses();
	}
	
	public boolean deleteCourse(String kno)
	{
		if(courseDao.deleteCourse(kno))
			return true;
		return false;
	}
	
	public boolean editCourse(String kno, String kname, String kproprety, Integer kcredit)
	{
		if(courseDao.editCourse(kno, kname, kproprety, kcredit))
			return true;
		return false;
	}
	
	public boolean addCourse(String kno, String kname, String kproprety, Integer kcredit)
	{
		Course course = new Course(kno,kname,kproprety,kcredit);
		
		if(courseDao.addCourse(course))
			return true;
		return false;
	}
	
	public Course findCourseByKno(String kno)
	{
		return courseDao.findCourseByKno(kno);
	}
}
