<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/init.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css">
	<link rel="stylesheet" type="text/css" href="style/css/common.css">
	
	</head>

	<body>
	<div id="page_title" ><img src="style/images/youjiantou.png"> [ 论坛  ]中的板块列表</div>
	<div>
		<img src="style/images/lubiao.png">
		<s:a action="forum_list">论坛</s:a>
	</div>
	<table>
		<tr class="tr_title">
			<td>板块</td>
			<td>主题数</td>
			<td>文章数</td>
			<td>最后发表的主题</td>
		</tr>
		<s:iterator value="#forumList">
		<tr>
			<td align="left" style="padding-left: 50px;">
				<img src="style/images/forum/default.png"/>		
				<s:a action="forum_show?forumId=%{id}">${name }</s:a>
			</td>
			<td>${topicCount }</td>
			<td>${articleCount }</td>
			<td align="left">
				┏ 主题 ：${lastTopic.title } <br/> 
				┣ 作者 ：${lastTopic.author.name }<br/> 
				┗ 时间 ：${lastTopic.postTime }<br/>
			</td>
		</tr>	
		</s:iterator>
	</table>
	</body>
</html>
