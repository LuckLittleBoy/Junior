package com.cms.grade.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.model.Grade;

public class GradeDao extends HibernateDaoSupport
{
	@SuppressWarnings("unchecked")
	public List<Grade> getGrade()
	{
		String sql = "select u from Grade u";
		List<Grade> list = new ArrayList<Grade>();
		try
		{
			list = this.getHibernateTemplate().find(sql);
			
		} catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteGrade(int gno)
	{
		try
		{
			Grade info = this.getHibernateTemplate().get(Grade.class, gno);
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

	public boolean editGrade(int gno ,int score)
	{
		Grade info = new Grade();

		try
		{
			info = (Grade)this.getHibernateTemplate().get(Grade.class,gno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(info!=null)
		{
			info.setScore(score);
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

	public boolean addGrade(Grade grade)
	{
		
		try
		{
			this.getHibernateTemplate().save(grade);
			this.getHibernateTemplate().flush();
			return true;
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Grade> findGradeBySno(String sno)
	{
		String sql = "select u from Grade u where u.sno='"+sno+"' and u.score>0";
		List<Grade> list = new ArrayList<Grade>();
		try
		{
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
