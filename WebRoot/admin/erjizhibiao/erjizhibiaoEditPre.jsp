<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

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
        <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        <script language="javascript">
           var i=0;
           function yijizhibiaoSelect()
           {
               if(i==0)
               {
                   document.getElementById("indicator").style.display="block";
                   loginService.yijizhibiaoSelect(callback);
                   i=1;
               }
               
           }
           function callback(data)
           {
               document.getElementById("indicator").style.display="none";
               DWRUtil.addOptions("yijizhibiaoId",data,"yijizhibiaoId","yijizhibiaoName");
           }
           
           function check()
           {
               if(document.formAdd.yijizhibiaoId.value==0)
               { 
                   alert("请选择一级指标");
                   return false;
               }
               document.formAdd.submit();
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/erjizhibiaoEdit.action" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/img/wbg.gif" class='title'><span>评价一级指标录入</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        一级指标：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <table border="0">
						           <tr> 
						               <td>  
						                  <select name="yijizhibiaoId" id="yijizhibiaoId" onclick="yijizhibiaoSelect()">
								              <option value="0">请选择一级指标</option>
								          </select>
						               </td>
						               <td><img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/></td>
						           </tr>
						        </table>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        二级指标名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text" name="erjizhibiaoName" size="50" value="${request.erjizhibiao.erjizhibiaoName }"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        二级指标权重：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text" value="${request.erjizhibiao.erjizhibiaoQuanzhong }" name="erjizhibiaoQuanzhong" size="20" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        二级指标分数：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" value="${request.erjizhibiao.erjizhibiaoFenshu }" name="erjizhibiaoFenshu" size="20" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="hidden" name="erjizhibiaoDi" value="${request.erjizhibiao.erjizhibiaoDi }"/>
						       <input type="button" value="提交" onclick="check()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
