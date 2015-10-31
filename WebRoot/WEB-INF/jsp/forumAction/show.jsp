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
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style/css/init.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css">
	<link rel="stylesheet" type="text/css" href="style/css/forum/show.css">
	<link rel="stylesheet" type="text/css" href="style/css/common.css">
	
<script type="text/javascript">
	function addTopic(url){
		location.href = url;
	}
</script>
  </head>
  
  <body>
  	<div id="page_title" ><img src="style/images/youjiantou.png"> [ ${forum.name } ]中的主题列表</div>
	<div>
		<img src="style/images/lubiao.png">
		<s:a action="forum_list">论坛</s:a>
		<img src="style/images/lubiao.png">
		${forum.name }
		<input class="btn_AddTopic" type="button" value="发新帖" onclick="addTopic('<s:url value="topic_addUI.action?forumId=%{#forum.id}"/>')"/>
	</div>
	<table cellpadding="0" cellspacing="0">
		<tr class="tr_title">
			<th></th>	<%-- 用来设置主题类型的 --%>
			<th>主题</th>
			<th>作者</th>
			<th>回复数</th>
			<th>最后回复</th>
		</tr>
		<s:iterator value="#topicList">
		<tr>
			<td><img alt="type" src="style/images/topic/${type }.png"></td>
			<td>
				<s:a action="topic_show?model.id=%{id}">${title }</s:a>
			</td>
			<td>
				${author.name }<br/>
				<span class="topic_postTime">${postTime }</span>
			</td>
			<td>${replyCount }</td>
			<td>${lastUpdateTime }</td>
		</tr>
		</s:iterator>
		<%--
		<tr class="tr_title">
			<td><s:select list="" listKey="" listValue="" headerKey="" headerValue="全部主题"></s:select></td>
			<td><s:select list="" listKey="" listValue="" headerKey="" headerValue="默认排序"></s:select></td>
			<td><s:select list="" listKey="" listValue="" headerKey="" headerValue="降序"></s:select></td>
			<td><input type="button" value="提交"/></td>
		</tr>
		 --%>
	</table>
	<div class="searchMenu">
		<%-- 模拟数据 --%>
		<select>
			<option>全部主题</option>
			<option>XXX</option>
		</select>
		<select>
			<option>默认排序</option>
			<option>XXX</option>
		</select>
		<select>
			<option>降序</option>
			<option>XXX</option>
		</select>
		<input type="button" value="提交"/>
	</div>
	<div style="width: 95%;height:50px;">
			<div style="float:left;width: 50%;margin-top:16px;">
			<ul>
				<li style="float: left;margin-right: 10px;">页次：${currentPage }/${pageCount }页</li>
				<li style="float: left;margin-right: 10px;">每页显示：${pageSize }条</li>
				<li>总记录数：${recordCount }条</li>
			</ul>
			</div>
			<s:if test="pageCount>1">
			<div style="float: right;width: 50%; margin-top:5.5px;">
			<ul style="float: right;">
				<s:iterator begin="beginPageIndex" end="endPageIndex" status="status">
					
					<s:if test="%{#status.count+beginPageIndex-1==currentPage}">
					<li style="display: block;float: left;padding: 7px 5px 7px 5px; border: 1px gray solid;margin: 5px 5px 0px 0px;background-color: white;">
						${status.count+beginPageIndex-1 }
						
					</li>
					</s:if>
					<s:else>
					<li style="display: block;float: left;padding: 7px 5px 7px 5px; border: 1px gray solid;margin: 5px 5px 0px 0px;background-color: white;">
						<a href="topic_show.action?currentPage=${status.count+beginPageIndex-1  }&id=${topic.id}">
							${status.count+beginPageIndex-1  }
						</a>
					</li>
					</s:else>
				</s:iterator>
				<li style="float: left;margin-top:15px;">
					传到：
					<select onchange="gotoPage(this.value)" id="selectValue">
						<s:iterator begin="1" end="pageCount" status="status">
							<option value="${status.count }">
								${status.count }
							</option>
						</s:iterator>
					</select>
				</li>
			</ul>
			</div>
			</s:if>
		</div>

  </body>
</html>
