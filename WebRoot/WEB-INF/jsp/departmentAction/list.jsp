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

		<title>部门管理界面</title>

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
				<td>部门名称</td>
				<td>上级部门</td>
				<td>部门说明</td>
				<td>相关操作</td>
			</tr>
			<s:iterator value="#departmentList" >
				<tr>
					<td>
						<s:a action="department_list?parentId=%{id }">${name }</s:a>  
					</td>
					<td>${parent.name }</td>
					<td>${description }</td>
					<td>
						<s:a action="department_delete?id=%{id }">删除</s:a>
						<s:a action="department_updateUI?id=%{id }">修改</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<hr/>
		<%--
		<a href="<c:url value='department_addUI.action?parentId=${parent.id }'></c:url>">新建</a>
		<s:param name="parentId" value="%{parent.id }"/>
		 --%>
		<s:a action="department_addUI?parentId=%{#parent.id}">新建</s:a>
		<s:if test="%{#parent.id != null}">
			<s:a action="department_list?parentId=%{#parent.parent.id}">返回上一级</s:a>
		</s:if>
	</body>
</html>
