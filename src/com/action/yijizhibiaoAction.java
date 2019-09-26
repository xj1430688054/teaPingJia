package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.ErjizhibiaoDAO;
import com.dao.YijizhibiaoDAO;
import com.model.Yijizhibiao;
import com.opensymphony.xwork2.ActionSupport;

public class yijizhibiaoAction extends ActionSupport
{
	private int yijizhibiaoId;
	private String yijizhibiaoName;
	private double yijizhibiaoQuanzhong;
	private double yijizhibiaoFenshu;
	
	private YijizhibiaoDAO yijizhibiaoDAO;
	private ErjizhibiaoDAO erjizhibiaoDAO;
	private String message;
	private String path;
	
	private int teaId;
	
	public String yijizhibiaoAdd()
	{
		Yijizhibiao yijizhibiao=new Yijizhibiao();
		yijizhibiao.setYijizhibiaoName(yijizhibiaoName);
		yijizhibiao.setYijizhibiaoQuanzhong(yijizhibiaoQuanzhong);
		yijizhibiao.setYijizhibiaoFenshu(yijizhibiaoFenshu);
		yijizhibiao.setDel("no");
		yijizhibiaoDAO.save(yijizhibiao);
		this.setMessage("操作成功");
		this.setPath("yijizhibiaoMana.action");
		return "succeed";
	}
	public String yijizhibiaoDel()
	{
		Yijizhibiao yijizhibiao=yijizhibiaoDAO.findById(yijizhibiaoId);
		yijizhibiao.setDel("yes");
		yijizhibiaoDAO.attachDirty(yijizhibiao);
		this.setMessage("操作成功");
		this.setPath("yijizhibiaoMana.action");
		return "succeed";
	}
	
	public String yijizhibiaoMana()
	{
		String sql="from Yijizhibiao where del='no'" ;
		List yijizhibiaoList=yijizhibiaoDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yijizhibiaoList", yijizhibiaoList);
		return ActionSupport.SUCCESS;
	}
	
	public String yijizhibiaoEditPre()
	{
		Yijizhibiao yijizhibiao=yijizhibiaoDAO.findById(yijizhibiaoId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yijizhibiao", yijizhibiao);
		return ActionSupport.SUCCESS;
	}
	
	public String yijizhibiaoEdit()
	{
		System.out.println(yijizhibiaoFenshu+"^^^");
		Yijizhibiao yijizhibiao=yijizhibiaoDAO.findById(yijizhibiaoId);
		yijizhibiao.setYijizhibiaoName(yijizhibiaoName);
		yijizhibiao.setYijizhibiaoQuanzhong(yijizhibiaoQuanzhong);
		yijizhibiao.setYijizhibiaoFenshu(yijizhibiaoFenshu);
		yijizhibiaoDAO.attachDirty(yijizhibiao);
		this.setMessage("操作成功");
		this.setPath("yijizhibiaoMana.action");
		return "succeed";
	}
	
	
	
	public String yijizhibiaoAll()
	{
		String sql="from Yijizhibiao where del='no'" ;
		List yijizhibiaoList=yijizhibiaoDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<yijizhibiaoList.size();i++)
		{
			Yijizhibiao yijizhibiao=(Yijizhibiao)yijizhibiaoList.get(i);
			String sql1="from Erjizhibiao where del='no' and yijizhibiaoId="+yijizhibiao.getYijizhibiaoId() ;
			yijizhibiao.setErjizhibiaoList(erjizhibiaoDAO.getHibernateTemplate().find(sql1));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yijizhibiaoList", yijizhibiaoList);
		request.put("teaId", teaId);
		return ActionSupport.SUCCESS;
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
	
	public int getTeaId()
	{
		return teaId;
	}

	public void setTeaId(int teaId)
	{
		this.teaId = teaId;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	public YijizhibiaoDAO getYijizhibiaoDAO()
	{
		return yijizhibiaoDAO;
	}
	public void setYijizhibiaoDAO(YijizhibiaoDAO yijizhibiaoDAO)
	{
		this.yijizhibiaoDAO = yijizhibiaoDAO;
	}
	

	public void setYijizhibiaoFenshu(float yijizhibiaoFenshu)
	{
		this.yijizhibiaoFenshu = yijizhibiaoFenshu;
	}

	public ErjizhibiaoDAO getErjizhibiaoDAO()
	{
		return erjizhibiaoDAO;
	}

	public void setErjizhibiaoDAO(ErjizhibiaoDAO erjizhibiaoDAO)
	{
		this.erjizhibiaoDAO = erjizhibiaoDAO;
	}

	public void setYijizhibiaoFenshu(int yijizhibiaoFenshu)
	{
		this.yijizhibiaoFenshu = yijizhibiaoFenshu;
	}
	public int getYijizhibiaoId()
	{
		return yijizhibiaoId;
	}
	public void setYijizhibiaoId(int yijizhibiaoId)
	{
		this.yijizhibiaoId = yijizhibiaoId;
	}
	public String getYijizhibiaoName()
	{
		return yijizhibiaoName;
	}
	public void setYijizhibiaoName(String yijizhibiaoName)
	{
		this.yijizhibiaoName = yijizhibiaoName;
	}
	public void setYijizhibiaoQuanzhong(float yijizhibiaoQuanzhong)
	{
		this.yijizhibiaoQuanzhong = yijizhibiaoQuanzhong;
	}

	public double getYijizhibiaoFenshu()
	{
		return yijizhibiaoFenshu;
	}

	public void setYijizhibiaoFenshu(double yijizhibiaoFenshu)
	{
		this.yijizhibiaoFenshu = yijizhibiaoFenshu;
	}

	public double getYijizhibiaoQuanzhong()
	{
		return yijizhibiaoQuanzhong;
	}

	public void setYijizhibiaoQuanzhong(double yijizhibiaoQuanzhong)
	{
		this.yijizhibiaoQuanzhong = yijizhibiaoQuanzhong;
	}
	
}
