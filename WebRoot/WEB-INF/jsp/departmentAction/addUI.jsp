<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加岗位界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  	<s:form action="department_add.action"  method="post" >
	<table>
		<tr>
			<td>上级部门</td>
			<td>
				<s:select list="#departmentList" name="parentId" listKey="id" listValue="name" headerKey="" headerValue="请选择上级部门"></s:select>
			</td>
		</tr>
		<tr>
			<td>部门名称</td>
			<td><input type="text" name="model.name"/></td>
		</tr>
		<tr>
			<td>部门说明</td>
			<td><input type="text" name="model.description"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="保存"/></td>
			<td><input type="button" value="返回" onclick="history.back(-1)"/></td>
		</tr>
	</table>
	</s:form>
  	
  </body>
</html>
