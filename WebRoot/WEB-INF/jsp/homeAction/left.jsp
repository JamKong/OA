<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<script type="text/javascript" src="script/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="script/menu_min.js"></script>
	<script type="text/javascript">
		$(document).ready(function (){
		  $(".menu ul li").menu();
		}); 
	</script> 
	
	<link rel="stylesheet" type="text/css" href="style/css/style.css"> 
	<link rel="stylesheet" type="text/css" href="style/css/menu-css.css">
 
</head>

<body>
<div id="content">
	<div class="menu" >
		<ul id="menuUI"  style="display: block;">
			<!-- 显示一级菜单 -->
			<s:iterator value="#application.topPrivilegeList">
				<!-- 判断权限 -->
				<s:if test="#session.user.hasPrivilegeByName(name)">
					<li class="active">
						<a href="javascript:void(0)">${name }</a>
						<ul class="menuList">
							<!-- 显示二级菜单 -->
							<s:iterator value="childrens">
								<!-- 判断权限 -->
								<s:if test="#session.user.hasPrivilegeByName(name)">
									<li>
										<div class="level2Style">
											<a target="right"
												href="${pageContext.request.contextPath }${url }.action">${name
												}</a>
										</div>
									</li>
								</s:if>
							</s:iterator>
						</ul>
					</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</div>
</body>
</html>
