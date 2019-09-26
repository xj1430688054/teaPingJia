package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.ErjizhibiaoDAO;
import com.dao.YijizhibiaoDAO;
import com.model.Erjizhibiao;
import com.model.Yijizhibiao;
import com.opensymphony.xwork2.ActionSupport;

public class erjizhibiaoAction extends ActionSupport
{
	private int erjizhibiaoDi;
	private String erjizhibiaoName;
	private double erjizhibiaoQuanzhong;
	private double erjizhibiaoFenshu;
	private int yijizhibiaoId;
	
	private ErjizhibiaoDAO erjizhibiaoDAO;
	private YijizhibiaoDAO yijizhibiaoDAO;
	private String message;
	private String path;
	
	public String erjizhibiaoAdd()
	{
		Erjizhibiao erjizhibiao=new Erjizhibiao();
		erjizhibiao.setErjizhibiaoName(erjizhibiaoName);
		erjizhibiao.setErjizhibiaoQuanzhong(erjizhibiaoQuanzhong);
		erjizhibiao.setErjizhibiaoFenshu(erjizhibiaoFenshu);
		erjizhibiao.setYijizhibiaoId(yijizhibiaoId);
		erjizhibiao.setDel("no");
		erjizhibiaoDAO.save(erjizhibiao);
		this.setMessage("操作成功");
		this.setPath("erjizhibiaoMana.action");
		return "succeed";
	}
	
	public String erjizhibiaoDel()
	{
		Erjizhibiao erjizhibiao=erjizhibiaoDAO.findById(erjizhibiaoDi);
		erjizhibiao.setDel("yes");
		erjizhibiaoDAO.attachDirty(erjizhibiao);
		this.setMessage("操作成功");
		this.setPath("erjizhibiaoMana.action");
		return "succeed";
	}
	
	public String erjizhibiaoMana()
	{
		String sql="from Erjizhibiao where del='no' order by yijizhibiaoId" ;
		List erjizhibiaoList=erjizhibiaoDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<erjizhibiaoList.size();i++)
		{
			Erjizhibiao erjizhibiao=(Erjizhibiao)erjizhibiaoList.get(i);
			erjizhibiao.setYijizhibiaoName(yijizhibiaoDAO.findById(erjizhibiao.getYijizhibiaoId()).getYijizhibiaoName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("erjizhibiaoList", erjizhibiaoList);
		return ActionSupport.SUCCESS;
	}
	
	public String erjizhibiaoEditPre()
	{
		Erjizhibiao erjizhibiao=erjizhibiaoDAO.findById(erjizhibiaoDi);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("erjizhibiao", erjizhibiao);
		return ActionSupport.SUCCESS;
	}
	
	public String erjizhibiaoEdit()
	{
		Erjizhibiao erjizhibiao=erjizhibiaoDAO.findById(erjizhibiaoDi);
		erjizhibiao.setErjizhibiaoName(erjizhibiaoName);
		erjizhibiao.setErjizhibiaoQuanzhong(erjizhibiaoQuanzhong);
		erjizhibiao.setErjizhibiaoFenshu(erjizhibiaoFenshu);
		erjizhibiao.setYijizhibiaoId(yijizhibiaoId);
		erjizhibiaoDAO.attachDirty(erjizhibiao);
		this.setMessage("操作成功");
		this.setPath("erjizhibiaoMana.action");
		return "succeed";
	}
	

	public int getErjizhibiaoDi()
	{
		return erjizhibiaoDi;
	}

	public void setErjizhibiaoDi(int erjizhibiaoDi)
	{
		this.erjizhibiaoDi = erjizhibiaoDi;
	}

	public double getErjizhibiaoFenshu()
	{
		return erjizhibiaoFenshu;
	}

	public ErjizhibiaoDAO getErjizhibiaoDAO()
	{
		return erjizhibiaoDAO;
	}

	public YijizhibiaoDAO getYijizhibiaoDAO()
	{
		return yijizhibiaoDAO;
	}

	public void setYijizhibiaoDAO(YijizhibiaoDAO yijizhibiaoDAO)
	{
		this.yijizhibiaoDAO = yijizhibiaoDAO;
	}

	public void setErjizhibiaoDAO(ErjizhibiaoDAO erjizhibiaoDAO)
	{
		this.erjizhibiaoDAO = erjizhibiaoDAO;
	}

	public void setErjizhibiaoFenshu(double erjizhibiaoFenshu)
	{
		this.erjizhibiaoFenshu = erjizhibiaoFenshu;
	}

	public String getErjizhibiaoName()
	{
		return erjizhibiaoName;
	}

	public void setErjizhibiaoName(String erjizhibiaoName)
	{
		this.erjizhibiaoName = erjizhibiaoName;
	}


	public double getErjizhibiaoQuanzhong()
	{
		return erjizhibiaoQuanzhong;
	}

	public void setErjizhibiaoQuanzhong(double erjizhibiaoQuanzhong)
	{
		this.erjizhibiaoQuanzhong = erjizhibiaoQuanzhong;
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

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getYijizhibiaoId()
	{
		return yijizhibiaoId;
	}

	public void setYijizhibiaoId(int yijizhibiaoId)
	{
		this.yijizhibiaoId = yijizhibiaoId;
	}
	
}
