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
    
    <title>设置权限界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="style/css/jquery.treeview.css" />
	
<script type="text/javascript" src="script/jquery-1.8.0.js"></script>
<script src="script/jquery.cookie.js" type="text/javascript"></script>
<script src="script/jquery.treeview.js" type="text/javascript"></script>
<script type="text/javascript">
	function selectAll(checked){
		$('[name=privilegeIds]').attr('checked',checked)
	}

	$(function(){
		//给每个权限添加单击事件
		$('[name=privilegeIds]').click(function(){
			//当选中或取消一个权限时，也同时选中或取消所有的下级权限
			$(this).siblings('ul').find('input').attr('checked',this.checked);
			//当选中一个权限时，也要选中所有的直接上级权限
			if(this.checked == true){
				$(this).parents('li').children('input').attr('checked',true);
			}
		});

		//给权限树添加样式
		$("#menuUI").treeview({
			  persist: "location",
			  collapsed: true,
			  unique: true
		});
		
	})
</script>  


  </head>
  
  <body>
  	
	<s:form action="role_setPrivilege.action" method="post">
		<input type="hidden" name="id" value="${role.id }"/>
		<input type="checkbox" id="cbSelectAll"
			 <s:if test="#privilegeList.size == privilegeIds.length">
			 	checked
			 </s:if>
		 onclick="selectAll(this.checked)"/>
		<label for="cbSelectAll">全选</label>
		<%--第一级菜单 --%>
		<ul id="menuUI">
		<s:iterator value="#application.topPrivilegeList">
		<li class="open">
			<input type="checkbox" name="privilegeIds" value="${id }"
				<s:if test="%{id in privilegeIds}">checked</s:if> 
			 id="${id }" />
			 <label for="${id }"><span>${name }</span></label>
			<%--第二级菜单 --%>
			<ul>
			<s:iterator value="childrens">
				<li class="open">
					<input type="checkbox" name="privilegeIds" value="${id }"
						<s:if test="%{id in privilegeIds}">checked</s:if> 
			 		id="${id }" />
			 		<label for="${id }"><span>${name }</span></label>
			 		<%--第三级菜单 --%>
					<ul>
					<s:iterator value="childrens">
					<li class="open">
						<input type="checkbox" name="privilegeIds" value="${id }"
							<s:if test="%{id in privilegeIds}">checked</s:if> 
						 id="${id }" 
						 />
						<label for="${id }"><span>${name }</span></label>
					</li>
					</s:iterator>
					</ul>
				</li>
			</s:iterator>
			</ul>
		</li>
		</s:iterator>
		</ul>
		<%--
		<s:checkboxlist list="#privilegeList" name="privilegeIds" listKey="id" listValue="name" ></s:checkboxlist>
		 --%>
		<input type="submit" value="保存"/>
		<input type="button" value="返回" onclick="history.back(-1);"/>
  	</s:form>
  	
  </body>
</html>
