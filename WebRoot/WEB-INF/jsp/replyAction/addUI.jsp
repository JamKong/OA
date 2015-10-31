<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" type="text/css" href="style/css/common.css">
	<link rel="stylesheet" type="text/css" href="style/css/reply/addUI.css">
	
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script> 
<script type="text/javascript">
	CKEDITOR.replace('replyContent');
</script> 
  </head>
  
  <body>
	<div class="lubiaoMenu">
		<img src="style/images/lubiao.png">
		<s:a action="forum_list">论坛</s:a>
		<img src="style/images/lubiao.png">
		<s:a action="forum_show?forumId=%{#topic.forum.id}">${topic.forum.name }</s:a>
		<img src="style/images/lubiao.png">
		帖子回复
	</div>
	<s:form action="reply_add" method="post">
	<s:hidden name="topicId" value="%{#topic.id}"></s:hidden>
	<table> 
		<tr>
			<td class="td_title">帖子主题</td>
			<td><input type="text" value="${topic.title }" readonly="readonly" id="topicTitle" class="td_content"/></td> 
		</tr>
		<tr>
			<td class="td_title">标题</td>
			<td><input type="text" name="model.title" value="回复:${topic.title }" class="td_content" readonly="readonly"/></td>
		</tr>
		<tr>
			<td class="td_title">内容</td>
			<td><textarea name="model.content" id="replyContent" class="ckeditor"></textarea></td>
		</tr>
		<tr>
			<td class="td_title"></td>
			<td>
				<input type="submit" value="提交" style="width: 80px;height: 30px;"/>
				<input type="button" value="返回" onclick="history.back(-1)" style="width: 80px;height: 30px;"/>
			</td>
		</tr>
	</table>
	</s:form>
	
  </body>
</html>
