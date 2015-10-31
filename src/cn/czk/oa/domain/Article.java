package cn.czk.oa.domain;

import java.util.Date;

public class Article {
	private Long id;		//主题id/回复的id	
	private String title;	//主题标题/回复的主题标题
	private String content; //主题的内容 / 回复的内容
	private Date postTime;	//主题的发表时间 / 回复的发表时间
	private User author;	//发表主题的作者 / 回复的作者
	private String ipAddr;	//作者的ip地址
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getPostTime() {
		return postTime;
	}
	public User getAuthor() {
		return author;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
}
