package com.cms.course.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.model.Course;

public class CourseDao extends HibernateDaoSupport
{
	@SuppressWarnings("unchecked")
	public List<Course> getCourses()
	{
		String sql = "select u from Course u";
		List<Course> list = new ArrayList<Course>();
		try
		{
			list = this.getHibernateTemplate().find(sql);
			
		} catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteCourse(String kno)
	{
		try
		{
			Course info = this.getHibernateTemplate().get(Course.class, kno);
			this.getHibernateTemplate().delete(info);
			this.getHibernateTemplate().flush();
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean editCourse(String kno, String kname, String kproprety, Integer kcredit)
	{
		Course info = new Course();

		try
		{
			info = (Course)this.getHibernateTemplate().get(Course.class,kno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(info!=null)
		{
			info.setKno(kno);
			info.setKname(kname);
			info.setKproprety(kproprety);
			info.setKcredit(kcredit);
		}
		try
		{
			this.getHibernateTemplate().update(info);
			this.getHibernateTemplate().flush();
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addCourse(Course course)
	{
		// TODO Auto-generated method stub
		try
		{
			this.getHibernateTemplate().save(course);
			this.getHibernateTemplate().flush();
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Course findCourseByKno(String kno)
	{
		Course info = new Course();

		try
		{
			info = (Course)this.getHibernateTemplate().get(Course.class,kno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return info;
	}
}
