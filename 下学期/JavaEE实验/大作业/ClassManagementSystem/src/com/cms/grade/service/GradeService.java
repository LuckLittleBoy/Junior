package com.cms.grade.service;

import java.util.List;

import com.cms.grade.dao.GradeDao;
import com.cms.model.Grade;

public class GradeService
{
	private GradeDao gradeDao;
	
	public GradeDao getGradeDao()
	{
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao)
	{
		this.gradeDao = gradeDao;
	}

	public List<Grade> getGrade()
	{
		return gradeDao.getGrade();
	}
	
	public boolean deleteGrade(int gno)
	{
		return gradeDao.deleteGrade(gno);
	}
	
	public boolean editGrade(int gno ,int score)
	{
		return gradeDao.editGrade(gno, score);
	}
	
	public boolean addGrade(String sno, String kno ,int score)
	{
		Grade grade = new Grade(sno,kno,score);
		return gradeDao.addGrade(grade);
	}

	public List<Grade> findGradeBySno(String sno)
	{
		return gradeDao.findGradeBySno(sno);
	}
}
