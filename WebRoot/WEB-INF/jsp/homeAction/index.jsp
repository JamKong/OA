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

		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
  	<frameset rows="100,*,25" framespacing="0" border="0" frameborder="no">
		<frame noresize="noresize" name="topMenu" scrolling="no" src="${pageContext.request.contextPath }/home_top.action">
		<frameset cols="250,*" id="resize">
			<frame noresize="noresize" name="menu" scrolling="auto" src="${pageContext.request.contextPath }/home_left.action">
			<frame noresize="noresize" name="right" scrolling="auto" src="${pageContext.request.contextPath }/home_right.action">
		</frameset>
		<frame noresize="noresize" name="status_bar" scrolling="no" src="${pageContext.request.contextPath }/home_bottom.action">
	</frameset>
	<body><noframes></noframes></body>
	
	 
	 
	
</html>
