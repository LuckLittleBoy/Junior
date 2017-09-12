package com.cms.grade.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.cms.grade.service.GradeService;
import com.cms.model.Grade;
import com.opensymphony.xwork2.ActionSupport;

public class OperateGradeAction extends ActionSupport
{
	private int gno;
	private String sno;
	private String kno;
	private int score=0;
	private int operateid;
	private GradeService gradeService;

	public GradeService getGradeService()
	{
		return gradeService;
	}

	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	public int getGno()
	{
		return gno;
	}

	public void setGno(int gno)
	{
		this.gno = gno;
	}

	public String getSno()
	{
		return sno;
	}

	public void setSno(String sno)
	{
		this.sno = sno;
	}

	public String getKno()
	{
		return kno;
	}

	public void setKno(String kno)
	{
		this.kno = kno;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getOperateid()
	{
		return operateid;
	}

	public void setOperateid(int operateid)
	{
		this.operateid = operateid;
	}

	public String execute() throws Exception
	{
		ServletActionContext.getRequest().getSession().setAttribute("child", "5");
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8");       
        PrintWriter out = response.getWriter(); 
		if(operateid==0)
		{
			gradeService.deleteGrade(gno);
		}
		else if(operateid==1)
		{
			gradeService.editGrade(gno, score);
		}
		else if(operateid==2)
		{
			ServletActionContext.getRequest().getSession().setAttribute("child", "6");
			List<Grade> list = gradeService.findGradeBySno(sno);
			JSONArray msg=JSONArray.fromObject(list);
			out.println(msg.toString());
			out.flush();
			out.close();
			return null;
		}
		else if(operateid==3)
		{
			ServletActionContext.getRequest().getSession().setAttribute("child", "4");
			gradeService.addGrade(sno, kno, score);
		}
		else
		{
			return null;
		}
		return null;
	}
	
}
