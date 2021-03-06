package com.stu.crud.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.db.DBBean;

public class AddStudent extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String name = request.getParameter("Name");
		DBBean db = new DBBean();
		String strSql = "insert into Student values('" + id + "','" + name + "')";    
		db.executeUpdate(strSql);
		response.sendRedirect("../StudentList.jsp");
	}
}
