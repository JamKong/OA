<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改岗位界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  	<s:form action="forumManage_update" method="post">
  	<input type="hidden" name="model.id" value="${forum.id }"/>
	<table>
		<tr>
			<td>板块名称</td>
			<td>
			<s:textfield name="model.name" ></s:textfield>
		</tr>
		<tr>
			<td>板块说明</td>
			<td>
			<s:textfield name="model.description"></s:textfield>
		</tr>
		<tr>
			<td><input type="submit" value="修改"/></td>
			<td><input type="button" value="返回" onclick="history.back(-1)"/></td>
		</tr>
	</table>
	</s:form>
  	
  </body>
</html>
