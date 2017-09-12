package com.cms.model;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable
{

	// Fields

	private Integer gno;
	private String sno;
	private String kno;
	private Integer score;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** full constructor */
	public Grade(String sno, String kno, Integer score)
	{
		this.sno = sno;
		this.kno = kno;
		this.score = score;
	}

	// Property accessors

	public Integer getGno()
	{
		return this.gno;
	}

	public void setGno(Integer gno)
	{
		this.gno = gno;
	}

	public String getSno()
	{
		return this.sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getKno()
	{
		return this.kno;
	}

	public void setKno(String kno)
	{
		this.kno = kno;
	}

	public Integer getScore()
	{
		return this.score;
	}

	public void setScore(Integer score)
	{
		this.score = score;
	}

}