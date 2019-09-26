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
		
        <script language="javascript">
           function teaDel(teaId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/teaDel.action?teaId="+teaId;
               }
           }
           
           function teaAdd()
           {
                 var url="<%=path %>/admin/tea/teaAdd.jsp";
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
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="7" background="<%=path %>/images/tbg.gif">&nbsp;老师管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
				    <td width="14%">编号</td>
					<td width="14%">姓名</td>
					<td width="14%">性别</td>
					<td width="14%">年龄</td>
					<td width="14%">登录账号</td>
					<td width="14%">登录密码</td>
					<td width="14%">操作</td>
		        </tr>	
				<s:iterator value="#request.teaList" id="tea">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaBianhao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaRealname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.teaSex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#tea.teaAge"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.loginName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#tea.loginPw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="teaDel(<s:property value="#tea.teaId"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="teaAdd()" />
			      <input type="button" value="打印" style="width: 80px;" onclick="dayin()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
