package com.cms.classInfo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.model.ClassInfo;

public class ClassInfoDao extends HibernateDaoSupport
{
	@SuppressWarnings("unchecked")
	public List<ClassInfo> getAllClass()
	{
		List<ClassInfo> list = new ArrayList<ClassInfo>();
		String sql = "select u from ClassInfo u";
		try
		{
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return list;	
	}
	
	public boolean addClassInfo(ClassInfo info)
	{
		try
		{
			this.getHibernateTemplate().saveOrUpdate(info);
			this.getHibernateTemplate().flush();
		} catch (DataAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteClassInfo(String cno)
	{
		
		try
		{
			ClassInfo info = this.getHibernateTemplate().get(ClassInfo.class, cno);
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
	
	public boolean editClassInfo(String cno,String cname)
	{
		ClassInfo info = new ClassInfo();

		try
		{
			info = (ClassInfo)this.getHibernateTemplate().get(ClassInfo.class,cno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(info!=null)
		{
			info.setCname(cname);
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
	
	public ClassInfo findClassByCno(String cno)
	{
		ClassInfo info = new ClassInfo();
		info=this.getHibernateTemplate().get(ClassInfo.class, cno);
		return info;
	}
}
