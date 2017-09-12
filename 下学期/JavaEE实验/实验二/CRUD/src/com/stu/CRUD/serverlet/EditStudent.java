package com.stu.CRUD.serverlet;

import com.opensymphony.xwork2.ActionSupport;
import com.stu.db.DBBean;

@SuppressWarnings("serial")
public class EditStudent extends ActionSupport
{
	private String ID = "";
	private String Name = "";
	
	// 函数 *********************************************************************
	public String getID()
	{
		return ID;
	}
	
	public void setID(String iD)
	{
		ID = iD;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setName(String name)
	{
		Name = name;
	}

	@Override
	public String execute() throws Exception
	{
		DBBean db = new DBBean();
		try
		{
			String strSql = "update Student set Name='" + getName() + "' where ID='" + getID() + "'";    
			db.executeUpdate(strSql);
		}
		catch (Exception e) 
		{
			return "Error";
		}
				
		return "Success";
		
	}
}
