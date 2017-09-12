package com.cms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private String sno;
	private String cno;
	private String sname;
	private String ssex;
	private String sbirth;
	private String spwd;
	private String stel;
	private String saddress;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String sno, String cno, String sname, String ssex,
			String sbirth, String spwd, String stel, String saddress)
	{
		this.sno = sno;
		this.cno = cno;
		this.sname = sname;
		this.ssex = ssex;
		this.sbirth = sbirth;
		this.spwd = spwd;
		this.stel = stel;
		this.saddress = saddress;
	}

	/** full constructor */
	public Student(String sno, String cno, String sname, String ssex,
			String sbirth, String spwd, String stel, String saddress, Set<Grade> grades)
	{
		this.sno = sno;
		this.cno = cno;
		this.sname = sname;
		this.ssex = ssex;
		this.sbirth = sbirth;
		this.spwd = spwd;
		this.stel = stel;
		this.saddress = saddress;
		this.grades = grades;
	}

	// Property accessors

	public String getSno()
	{
		return this.sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getCno()
	{
		return this.cno;
	}

	public void setCno(String cno)
	{
		this.cno = cno;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public String getSsex()
	{
		return this.ssex;
	}

	public void setSsex(String ssex)
	{
		this.ssex = ssex;
	}

	public String getSbirth()
	{
		return this.sbirth;
	}

	public void setSbirth(String sbirth)
	{
		this.sbirth = sbirth;
	}

	public String getSpwd()
	{
		return this.spwd;
	}

	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
	}

	public String getStel()
	{
		return this.stel;
	}

	public void setStel(String stel)
	{
		this.stel = stel;
	}

	public String getSaddress()
	{
		return this.saddress;
	}

	public void setSaddress(String saddress)
	{
		this.saddress = saddress;
	}

	public Set<Grade> getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set<Grade> grades)
	{
		this.grades = grades;
	}

}