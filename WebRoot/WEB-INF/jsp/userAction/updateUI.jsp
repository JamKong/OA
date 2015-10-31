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
    
    <title>修改用户界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  
  	<s:form action="user_update.action" method="post">
  	<input type="hidden" name="id" value="${user.id }"/>
	<table>
		<tr><td>用户信息</td></tr>
		<tr>
			<td>所属部门</td>
			<td>
				<s:select list="#departmentList" listKey="id" listValue="name"></s:select>
			</td>
		</tr>
		<tr>
			<td>登录名</td>
			<td><input type="text" name="model.username" value="${user.username }"/></td>
			<td>*(登录名要唯一)</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="model.name" value="${user.name }"/></td>
			<td>*</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<s:radio list="{'男','女'}" name="model.gender" value="%{#user.gender}"></s:radio>
			</td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="model.phoneNumber" value="${user.phoneNumber }"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="model.email" value="${user.email }"/></td>
		</tr>
		<tr>
			<td>备注</td>
			<td>
				<textarea rows="5" cols="25" name="model.description" >${user.description }</textarea>
			</td>
		</tr>
		<tr><td>岗位设置</td></tr>
		<tr>
			<td>岗位</td>
			<td>
			<!-- 因为多选这部门回显数据比较难实现，所以采用Struts2的标签 -->
			 	<s:select list="#roleList"  listKey="id" listValue="name" name="roleIds" cssClass="SelectStyle"
			 		multiple="true" size="10">
			 	</s:select>
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
