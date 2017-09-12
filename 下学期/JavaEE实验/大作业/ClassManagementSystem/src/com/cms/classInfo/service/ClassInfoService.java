package com.cms.classInfo.service;

import java.util.List;

import com.cms.classInfo.dao.ClassInfoDao;
import com.cms.model.ClassInfo;

public class ClassInfoService
{
	private ClassInfoDao classInfodao;

	public ClassInfoDao getClassInfodao()
	{
		return classInfodao;
	}
	public void setClassInfodao(ClassInfoDao classInfodao)
	{
		this.classInfodao = classInfodao;
	}
	
	public List<ClassInfo> getAllClass()
	{
		List<ClassInfo> list = classInfodao.getAllClass();
		return list;
	}
	
	public boolean addClassInfo(String cno,String cname)
	{
		ClassInfo info = new ClassInfo();
		info.setCno(cno);
		info.setCname(cname);
		if(classInfodao.addClassInfo(info))
			return true;
		return false;
	}
	
	public boolean deleteClassInfo(String cno)
	{
		if(classInfodao.deleteClassInfo(cno))
			return true;
		return false;
	}
	
	public boolean editClassInfo(String cno,String cname)
	{
		if(classInfodao.editClassInfo(cno,cname))
			return true;
		return false;
	}
	
	public ClassInfo findClassByCno(String cno)
	{
		ClassInfo info = new ClassInfo();
		info = classInfodao.findClassByCno(cno);
		return info;
	}
}
