package cn.czk.oa.domain;

import java.util.Set;

/**
 * 论坛
 * @author Administrator
 *
 */
public class Forum {
	private Long id;
	private String name;
	private String description;
	private int position;
	
	private Set<Topic> topics;	//主题
	private int topicCount;		//主题总数
	private int articleCount;	//文章总数 = 主题+回复
	private Topic lastTopic;	//最新主题
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPosition() {
		return position;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	
}
