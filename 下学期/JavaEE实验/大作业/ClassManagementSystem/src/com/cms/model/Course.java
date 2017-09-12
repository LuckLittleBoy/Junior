package com.cms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable
{

	// Fields

	private String kno;
	private String kname;
	private String kproprety;
	private Integer kcredit;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String kno, String kname, String kproprety, Integer kcredit)
	{
		this.kno = kno;
		this.kname = kname;
		this.kproprety = kproprety;
		this.kcredit = kcredit;
	}

	/** full constructor */
	public Course(String kno, String kname, String kproprety, Integer kcredit,
			Set<Grade> grades)
	{
		this.kno = kno;
		this.kname = kname;
		this.kproprety = kproprety;
		this.kcredit = kcredit;
		this.grades = grades;
	}

	// Property accessors

	public String getKno()
	{
		return this.kno;
	}

	public void setKno(String kno)
	{
		this.kno = kno;
	}

	public String getKname()
	{
		return this.kname;
	}

	public void setKname(String kname)
	{
		this.kname = kname;
	}

	public String getKproprety()
	{
		return this.kproprety;
	}

	public void setKproprety(String kproprety)
	{
		this.kproprety = kproprety;
	}

	public Integer getKcredit()
	{
		return this.kcredit;
	}

	public void setKcredit(Integer kcredit)
	{
		this.kcredit = kcredit;
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