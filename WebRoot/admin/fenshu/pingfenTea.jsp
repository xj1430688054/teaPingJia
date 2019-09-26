<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function adminDel(userId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/adminDel.action?userId="+userId;
               }
           }
           
           function adminAdd()
           {
                 var url="<%=path %>/admin/index/adminAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           function dayin()
           {
              window.print();
           }
           function back1()
           {
              window.history.back();
           }
           
           function pingfenDetail(teaId,stuId)
		    {   
		        var url="<%=path %>/pingfenDetail.action?fenshuTeaId="+teaId+"&fenshuStuId="+stuId;
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","");
	            pop.build();
	            pop.show();
		    }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">&nbsp;评价&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">分数</td>
					<td width="25%">评价日期</td>
					<td width="25%">学生</td>
					<td width="25%">详细信息</td>
		        </tr>	
				<s:iterator value="#request.fuzhuList" id="fuzhu" >
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#fuzhu.zongfenshu"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#fuzhu.shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#fuzhu.stuName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="pingfenDetail(<s:property value="#request.teaId"/>,<s:property value="#fuzhu.stuId"/>)">详细信息</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="返回" style="width: 80px;" onclick="back1()" />
			      <input type="button" value="打印" style="width: 80px;" onclick="dayin()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
