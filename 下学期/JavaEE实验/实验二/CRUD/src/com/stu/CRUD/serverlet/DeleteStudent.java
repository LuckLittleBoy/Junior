package com.stu.CRUD.serverlet;

import com.opensymphony.xwork2.ActionSupport;
import com.stu.db.DBBean;

public class DeleteStudent extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 变量 *********************************************************************
	private String ID = "";

	// 函数 *********************************************************************
	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	@Override
	public String execute() throws Exception
	{
		DBBean db = new DBBean();
		try
		{
			String strSql = "delete from Student where ID='" + getID() + "'";    
			db.executeUpdate(strSql);
		}
		catch (Exception e) 
		{
			return "Error";
		}
				
		return "Success";
	}
}
