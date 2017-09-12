package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hbm.HibernateSessionFactory;
import com.model.Users;


public class UserDao
{
     @SuppressWarnings("unchecked")
	public static List<Users> findAll()
     {
    	 Session session = HibernateSessionFactory.getSession();
    	 session.beginTransaction();
    	 String sql="from Users";
    	 List<Users> ls = session.createQuery(sql).list();
    	 session.getTransaction().commit();
    	 return ls;
     }
     public static void insert(Users u)
     {
    	 try
		{
    		 Session session = HibernateSessionFactory.getSession();
        	 session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public static void update(Users u)
     {
    	 try
		{
			Session session = HibernateSessionFactory.getSession();
			 session.beginTransaction();
			 session.update(u);
			 session.getTransaction().commit();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public static void delete(Users u)
     {
    	 try
		{
			Session session = HibernateSessionFactory.getSession();
			 session.beginTransaction();
			 session.delete(u);
			 session.getTransaction().commit();
		} catch (HibernateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
}
