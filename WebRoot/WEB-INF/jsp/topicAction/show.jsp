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
    
    <title>主题页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="style/css/init.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css">
	<link rel="stylesheet" type="text/css" href="style/css/common.css">
	<link rel="stylesheet" type="text/css" href="style/css/table.css"> 
	<link rel="stylesheet" type="text/css" href="style/css/topic/show.css">
	
<script type="text/javascript" src="script/jquery-1.8.0.js"></script>
<script type="text/javascript">
	//新建主题
	function addTopic(url){
		location.href = url;
	}
	//下拉菜单实现跳转
	function gotoPage(pageNum){
		window.location.href="topic_show.action?id="+${topic.id}+"&currentPage="+pageNum;
	}
	//设置下拉菜单的选中值
	$(window).load(function() {
		$("#selectValue").val("${currentPage}");
    });
</script>
  </head>
  
  <body>
  	<div class="lubiaoMenu">
		<img src="style/images/lubiao.png">
		<s:a action="forum_list">论坛</s:a>
		<img src="style/images/lubiao.png">
		<s:a action="forum_show?forumId=%{#topic.forum.id}">${topic.forum.name }</s:a>
		<img src="style/images/lubiao.png">
		主题浏览
		<input class="btn_AddTopic" type="button" value="发新帖" onclick="addTopic('<s:url value="topic_addUI.action?forumId=%{#topic.forum.id}"/>')"/>
	</div>
	<table>
		<tr class="tr_title">
			<td colspan="2">
				<div class="topic_title">本帖主题：${topic.title }</div>
				<div class="topic_edit_menu">
					<s:a action="reply_addUI?topicId=%{#topic.id}" cssStyle="color:white;">回复</s:a>
					<s:a action="topic_moveUI?id=%{#topic.id}" cssStyle="color:white;">移动到其它板块</s:a>
					<s:a action="topic_editType?id=%{#topic.id}&type=1" cssStyle="color:white;"><img alt="精华" src="style/images/topic/1.png"/>精</s:a>
					<s:a action="topic_editType?id=%{#topic.id}&type=2" cssStyle="color:white;"><img alt="置顶" src="style/images/topic/2.png"/>顶</s:a>
					<s:a action="topic_editType?id=%{#topic.id}&type=0" cssStyle="color:white;"><img alt="普通" src="style/images/topic/0.png"/>普</s:a>
				</div>
			</td>
		</tr>
		<s:if test="%{currentPage == 1}">
		<tr>
			<td class="touXiang">
				<div style="padding: 20px 20px 55px 20px;float: left;">
					<img alt="头像" src="style/images/touxiang.png"><br/>
					<span style="text-align:content;">${topic.author.name}</span>
				</div>
			</td>
			<td>
				<div class="info">
					<div class="top">
						<span class="top_title">${topic.title }</span>
						<span class="topic_edit_menu">
							<s:a action="topic_updateUI?id=%{#topic.id}" cssClass="edithTopicMenu">编辑</s:a>
							<s:a action="topic_delete?id=%{#topic.id}" >删除</s:a>
						</span>
						<hr style="clear: both; border-style: dotted; "/>
					</div>
					<div class="middle">
						${topic.content }
					</div>
					<div class="bottom">
						<span class="louShu" >[楼主]</span> 
						<span class="postTime">${topic.postTime}</span>
					</div>
				</div>
			</td>
		</tr>
		</s:if>
		<s:iterator value="recordList" status="status">
		<tr class="reply">
			<td class="touXiang" valign="top">
				<div style="padding: 20px 20px 55px 20px;" >
					<img alt="头像" src="style/images/touxiang.png"><br/>
					<span style="text-align:content;">${author.name}</span>
				</div>
			</td>
			<td>
				<div class="info">
					<div class="top">
						<span class="top_title">${title }</span>
						<span class="topic_edit_menu">
							<s:a action="reply_updateUI?id=%{id}" cssClass="edithTopicMenu">编辑</s:a>
							<s:a action="reply_delete?id=%{id}" >删除</s:a>
						</span>
						<hr style="clear: both; border-style: dotted; "/>
					</div>
					<div class="middle">
						${content }
					</div>
					<div class="bottom">
						<span class="louShu">[${(currentPage -1)*pageSize+status.count }楼]</span> 
						<span class="postTime">${postTime}</span>
					</div>
				</div>
			</td>
		</tr>
		</s:iterator> 
		
	</table>
	
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
