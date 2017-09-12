package com.cms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassInfo entity. @author MyEclipse Persistence Tools
 */

public class ClassInfo implements java.io.Serializable
{

	// Fields

	private String cno;
	private String cname;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public ClassInfo()
	{
	}

	/** minimal constructor */
	public ClassInfo(String cno, String cname)
	{
		this.cno = cno;
		this.cname = cname;
	}

	/** full constructor */
	public ClassInfo(String cno, String cname, Set<Student> students)
	{
		this.cno = cno;
		this.cname = cname;
		this.students = students;
	}

	// Property accessors

	public String getCno()
	{
		return this.cno;
	}

	public void setCno(String cno)
	{
		this.cno = cno;
	}

	public String getCname()
	{
		return this.cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public Set<Student> getStudents()
	{
		return this.students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

}