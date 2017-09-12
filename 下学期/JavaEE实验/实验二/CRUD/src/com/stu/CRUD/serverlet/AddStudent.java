package com.stu.CRUD.serverlet;
import com.opensymphony.xwork2.ActionSupport;
import com.stu.db.DBBean;

public class AddStudent extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 变量 *********************************************************************
	private String ID = "";
	private String Name = "";
	private String msg = "";
	
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
	
	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	@Override
	public String execute() throws Exception
	{
		DBBean db = new DBBean();
		try
		{
			String strSql = "insert into Student values('" + getID() + "','" + getName() + "')";    
			db.executeUpdate(strSql);
		}
		catch (Exception e) 
		{
			setMsg("学号重复!");
			return "Error";
		}	
		return "Success";
	}
}
