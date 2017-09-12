package com.cms.student.service;

import java.util.List;

import com.cms.model.Student;
import com.cms.student.dao.StudentDao;

public class StudentService
{
	private StudentDao stuDao;
	
	public StudentDao getStuDao()
	{
		return stuDao;
	}
	public void setStuDao(StudentDao stuDao)
	{
		this.stuDao = stuDao;
	}
	
	public boolean UserLogin(String sno, String pwd)
	{
		if(stuDao.StudentLogin(sno,pwd))
		{
			return true;
		}
		return false;
	}
	public boolean UserRegister(String sno,String sname,String ssex,String sbirth,
			String spwd,String stel,String saddress,String cno)
	{
		Student stu = new Student(sno, cno, sname, ssex,
				sbirth, spwd, stel, saddress);
		if(stuDao.StudentRegister(stu))
			return true;
		return false;
	}
	
	public List<Student> getStudents()
	{
		return stuDao.getStudents();
	}
	
	public boolean deleteStudent(String sno)
	{
		if(stuDao.deleteStudent(sno))
			return true;
		return false;
	}
	
	public boolean editStudent(String sno,String sname,String ssex,String sbirth,
			String spwd,String stel,String saddress,String cno)
	{
		if(stuDao.editStudent(sno, cno, sname, ssex,
				sbirth, spwd, stel, saddress))
			return true;
		return false;
	}
	
	public Student findStudentBySno(String sno)
	{
		Student stu = new Student();
		stu = stuDao.findStudentBySno(sno);
		return stu;
	}
}
