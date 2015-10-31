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
    
    <title>添加用户界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  	<s:form action="user_add.action" method="post" >
	<table>
		<tr><td>用户信息</td></tr>
		<tr>
			<td>所属部门</td>
			<td>
				<s:select list="#departmentList" listKey="id" listValue="name" headerKey="" headerValue="请选择上级部门"></s:select>
			</td>
		</tr>
		<tr>
			<td>登录名</td>
			<td><input type="text" name="model.username"/></td>
			<td>*(登录名要唯一)</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="model.name"/></td>
			<td>*</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="model.gender" value="男"/>男
				<input type="radio" name="model.gender" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="model.phoneNumber"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="model.email"/></td>
		</tr>
		<tr>
			<td>备注</td>
			<td>
				<textarea rows="5" cols="25" name="model.description"></textarea>
			</td>
		</tr>
		<tr><td>岗位设置</td></tr>
		<tr>
			<td>岗位</td>
			<td >
				<s:select list="#roleList" multiple="true" listKey="id" listValue="name" name="roleIds"></s:select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="保存"/></td>
			<td><input type="button" value="返回" onclick="history.back(-1)"/></td>
		</tr>
	</table>
	</s:form>
  	
  </body>
</html>
