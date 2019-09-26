package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.ErjizhibiaoDAO;
import com.dao.FenshuDAO;
import com.dao.TStuDAO;
import com.model.Erjizhibiao;
import com.model.Fenshu;
import com.model.TStu;
import com.model.TTea;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Fuzhu;

public class pingFenAction extends ActionSupport
{
	private ErjizhibiaoDAO erjizhibiaoDAO;
	private FenshuDAO fenshuDAO;
	private TStuDAO stuDAO;
	private int teaId;
	
	private String message;
	private String path;
	
	public String pingFenAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Map session= ServletActionContext.getContext().getSession();
		TStu stu=(TStu)session.get("stu");
		
		String sql1="from Fenshu where fenshuTeaId=? and fenshuStuId=?" ;
		Object[] c={teaId,stu.getStuId()};
		List list=fenshuDAO.getHibernateTemplate().find(sql1,c);
		if(list.size()>0)
		{
			this.setMessage("改老师已经评，请不要重复评价");
			this.setPath("teaAll.action");
		}
		else
		{
			String sql="from Erjizhibiao where del='no' order by yijizhibiaoId" ;
			List erjizhibiaoList=erjizhibiaoDAO.getHibernateTemplate().find(sql);
			for(int i=0;i<erjizhibiaoList.size();i++)
			{
				Erjizhibiao erjizhibiao=(Erjizhibiao)erjizhibiaoList.get(i);
				Fenshu fenshu=new Fenshu();
				fenshu.setFenshuFenshu(Double.parseDouble(request.getParameter(erjizhibiao.getErjizhibiaoDi().toString())));
				fenshu.setFenshuErjizhibiaoId(erjizhibiao.getErjizhibiaoDi());
				fenshu.setFenshuTeaId(teaId);
				
				fenshu.setFenshuStuId(stu.getStuId());
				fenshu.setShijian(new Date().toLocaleString());
				fenshuDAO.save(fenshu);
				
			}
			this.setMessage("操作成功");
			this.setPath("teaAll.action");
		}
		
		return "succeed";
	}
	
	public String pingFenMy()
	{
		
		List fuzhuList=new ArrayList();
		
		Map session= ServletActionContext.getContext().getSession();
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TTea tea=(TTea)session.get("tea");
		String sql="select sum(fenshuFenshu),fenshuStuId,shijian from Fenshu where fenshuTeaId="+tea.getTeaId()+" group by fenshuStuId,shijian order by sum(fenshuFenshu) desc";
		System.out.println(sql+"&&&");
		List Fenshulist=fenshuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<Fenshulist.size();i++)
		{
			Object[] o=(Object[])Fenshulist.get(i);
			Fuzhu fuzhu=new Fuzhu();
			fuzhu.setZongfenshu(o[0].toString());
			fuzhu.setStuId(o[1].toString());
			fuzhu.setStuName(stuDAO.findById(Integer.parseInt(o[1].toString())).getStuRealname());
			fuzhu.setShijian(o[2].toString());
			fuzhuList.add(fuzhu);
		}
		request.put("fuzhuList", fuzhuList);
		request.put("teaId", tea.getTeaId());
		return ActionSupport.SUCCESS;
	}
	
	public String pingfenTea()
	{
		List fuzhuList=new ArrayList();
		
		String sql="select sum(fenshuFenshu),fenshuStuId,shijian from Fenshu where fenshuTeaId="+teaId+" group by fenshuStuId,shijian order by sum(fenshuFenshu) desc";
		System.out.println(sql+"&&&");
		List Fenshulist=fenshuDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<Fenshulist.size();i++)
		{
			Object[] o=(Object[])Fenshulist.get(i);
			
			Fuzhu fuzhu=new Fuzhu();
			fuzhu.setZongfenshu(o[0].toString());
			fuzhu.setStuId(o[1].toString());
			fuzhu.setStuName(stuDAO.findById(Integer.parseInt(o[1].toString())).getStuRealname());
			fuzhu.setShijian(o[2].toString());
			fuzhuList.add(fuzhu);
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("fuzhuList", fuzhuList);
		request.put("teaId", teaId);
		return ActionSupport.SUCCESS;
	}
	
	
	public String pingfenDetail()
	{
		HttpServletRequest req=ServletActionContext.getRequest();
		
		String sql="from Fenshu where fenshuTeaId=? and fenshuStuId=?";
		Object c[]={Integer.parseInt(req.getParameter("fenshuTeaId")),Integer.parseInt(req.getParameter("fenshuStuId"))};
		List fenshulist=fenshuDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<fenshulist.size();i++)
		{
			Fenshu fenshu=(Fenshu)fenshulist.get(i);
			fenshu.setFenshuErjizhibiaoName(erjizhibiaoDAO.findById(fenshu.getFenshuErjizhibiaoId()).getErjizhibiaoName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("fenshulist", fenshulist);
		return ActionSupport.SUCCESS;
	}
	
	public ErjizhibiaoDAO getErjizhibiaoDAO()
	{
		return erjizhibiaoDAO;
	}
	public void setErjizhibiaoDAO(ErjizhibiaoDAO erjizhibiaoDAO)
	{
		this.erjizhibiaoDAO = erjizhibiaoDAO;
	}
	public int getTeaId()
	{
		return teaId;
	}
	
	public TStuDAO getStuDAO()
	{
		return stuDAO;
	}

	public void setStuDAO(TStuDAO stuDAO)
	{
		this.stuDAO = stuDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public FenshuDAO getFenshuDAO()
	{
		return fenshuDAO;
	}

	public void setFenshuDAO(FenshuDAO fenshuDAO)
	{
		this.fenshuDAO = fenshuDAO;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public void setTeaId(int teaId)
	{
		this.teaId = teaId;
	}

}
