package com.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TStuDAO;
import com.dao.TTeaDAO;
import com.dao.YijizhibiaoDAO;
import com.model.TAdmin;
import com.model.TStu;
import com.model.TTea;

public class loginService
{
	private TAdminDAO adminDAO;
	private TStuDAO stuDAO;
	private TTeaDAO teaDAO;
	private YijizhibiaoDAO yijizhibiaoDAO;
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	
	
	public YijizhibiaoDAO getYijizhibiaoDAO()
	{
		return yijizhibiaoDAO;
	}
	public void setYijizhibiaoDAO(YijizhibiaoDAO yijizhibiaoDAO)
	{
		this.yijizhibiaoDAO = yijizhibiaoDAO;
	}
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}
	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}
	public TTeaDAO getTeaDAO()
	{
		return teaDAO;
	}
	public void setTeaDAO(TTeaDAO teaDAO)
	{
		this.teaDAO = teaDAO;
	}
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName,userPw};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
			
		}
		if(userType==1)//老师登陆
		{
			String sql="from TTea where loginName=? and loginPw=?";
			Object[] con={userName,userPw};
			List teaList=teaDAO.getHibernateTemplate().find(sql,con);
			if(teaList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TTea tea=(TTea)teaList.get(0);
				 session.setAttribute("userType", 1);
	             session.setAttribute("tea", tea);
	             result="yes";
			}
		}
		if(userType==2)//学生登陆
		{
			String sql="from TStu where loginName=? and loginPw=?";
			Object[] con={userName,userPw};
			List stuList=stuDAO.getHibernateTemplate().find(sql,con);
			if(stuList.size()==0)
			{
				 result="no";
			}
			else
			{
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TStu stu=(TStu)stuList.get(0);
				 session.setAttribute("userType", 2);
	             session.setAttribute("stu", stu);
	             result="yes";
			}
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    
    public List yijizhibiaoSelect()
    {
    	String sql="from Yijizhibiao where del='no'" ;
		List yijizhibiaoList=yijizhibiaoDAO.getHibernateTemplate().find(sql);
		return yijizhibiaoList;
    }

}
