package com.cms.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cms.model.ClassInfo;
import com.cms.model.Student;

public class StudentDao extends HibernateDaoSupport
{
	@SuppressWarnings("unchecked")
	public boolean StudentLogin(String sno, String pwd)
	{
		try
		{
			List<Student> list = new ArrayList<Student>();
			String sql = "select u from Student u where u.sno = '"+sno+"' and u.spwd = '"+pwd+"'";
			list = this.getHibernateTemplate().find(sql);
			if(list.size()>=1)
			{
				return true;
			}
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean StudentRegister(Student stu)
	{
		try
		{
			this.getHibernateTemplate().save(stu);
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
	public List<Student> getStudents()
	{
		String sql = "select u from Student u";
		List<Student> stulist = new ArrayList<Student>();
		try
		{
			stulist = this.getHibernateTemplate().find(sql);
			
		} catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return stulist;
	}

	public boolean deleteStudent(String sno)
	{
		try
		{
			Student info = this.getHibernateTemplate().get(Student.class, sno);
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

	public boolean editStudent(String sno, String cno, String sname,
			String ssex, String sbirth, String spwd, String stel,
			String saddress)
	{
		Student info = new Student();

		try
		{
			info = (Student)this.getHibernateTemplate().get(Student.class,sno);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		if(info!=null)
		{
			info.setSno(sno);
			info.setSname(sname);
			info.setCno(cno);
			info.setSsex(ssex);
			info.setSbirth(sbirth);
			info.setSpwd(spwd);
			info.setStel(stel);
			info.setSaddress(saddress);
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

	public Student findStudentBySno(String sno)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
