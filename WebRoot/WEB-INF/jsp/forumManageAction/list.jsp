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

		<title>岗位管理界面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/init.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css">
	<link rel="stylesheet" type="text/css" href="style/css/common.css">
<style type="text/css">
	.disabled{
		color: gray;
		cursor: pointer;
	}
</style>

	</head>

<body>
	<div id="page_title" ><img src="style/images/youjiantou.png"> [ 论坛管理  ]中的板块列表</div>
	<div>
		<img src="style/images/lubiao.png">
		<s:a action="forumManage_list">论坛管理</s:a>
	</div>
	<table>
		<tr class="tr_title">
			<td>板块名称</td>
			<td>板块说明</td>
			<td>相关操作</td> 
		</tr>
		<s:iterator value="#list" status="status">
			<tr>
				<td>${name }</td>
				<td>${description }</td>
				<td>
					<s:a action="forumManage_delete?id=%{id}">删除</s:a>
					<s:a action="forumManage_delete?id=%{id}">修改</s:a>
					<s:if test="#status.first">
						<span class="disabled">上移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveUp?id=%{id}">上移</s:a>
					</s:else>
					<s:if test="#status.last">
						<span class="disabled">下移</span>
					</s:if>
					<s:else>
						<s:a action="forumManage_moveDown?id=%{id}">下移</s:a>
					</s:else>
				</td>
			</tr>
		</s:iterator>
	</table>
	<hr/>
	<s:a action="forumManage_addUI">新建</s:a>
</body>
</html>
