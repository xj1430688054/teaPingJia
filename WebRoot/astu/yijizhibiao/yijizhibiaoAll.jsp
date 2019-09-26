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
       </script>
	</head>

	<body>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <font color="red">文本框里的默认值是最高分。请认真评价。</font>
	    <form action="<%=path %>/pingFenAdd.action" name="" method="post">
	    <s:iterator value="#request.yijizhibiaoList" id="yijizhibiao">
		<fieldset style="width:700px; margin-left:20px;"><legend class="fieldtitle"><s:property value="#yijizhibiao.yijizhibiaoName"/></legend>
			<table class="bill" width="97%">
			    <s:iterator value="#request.yijizhibiao.erjizhibiaoList" id="erjizhibiao">
			    <tr>
			       <td width="300">
			         <s:property value="#erjizhibiao.erjizhibiaoName"/>
			       </td>
			       <td>
			         <input type="text" name="<s:property value="#erjizhibiao.erjizhibiaoDi"/>" value="<s:property value="#erjizhibiao.erjizhibiaoFenshu"/>" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>
			       </td>
			    </tr>
			    </s:iterator>
			</table>
		</fieldset><br/><br/>
		</s:iterator>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="hidden" name="teaId" value="<s:property value="#request.teaId"/>"/>
		<input type="submit" value="提交"/>
		</form>
	</body>
</html>
