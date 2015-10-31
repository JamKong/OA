<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户管理界面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/init.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css">

	</head>

	<body>
		<table>
			<tr class="tr_title">
				<td>用户名称</td>
				<td>用户说明</td>
				<td>相关操作</td>
			</tr>
			<s:iterator value="#userList">
				<tr>
					<td>${name }</td>
					<td>${description }</td>
					<td>
						<s:a action="user_delete.action?id=%{id}">删除</s:a>
						<s:a action="user_updateUI.action?id=%{id}">修改</s:a>
						<s:a action="user_initPassword.action?id=%{id}">初始化密码</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<s:a action="user_addUI.action">新建</s:a>
	</body>
</html>
