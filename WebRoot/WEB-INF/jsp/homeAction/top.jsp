<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	</head>

	<body style="background-color: #F2F2F2"> 
		<h1>OA系统</h1>
		<div style="float:right;">
			<a href="javascript:void(0);">您好,${user.name }</a>
			<a href="javascript:void(0);">个人设置</a>
		</div>
		<br>
		<div style="float:right;">
			<a href="javascript:void(0);">桌面</a>
			<a href="javascript:void(0);" onclick="window.parent.location.href='user_logout.action'">退出</a>
		</div>
		<a href="javascript:void(0);">消息</a>
		<a href="javascript:void(0);">邮件</a>
		<a href="javascript:void(0);">待办事项</a>
	</body>
</html>
