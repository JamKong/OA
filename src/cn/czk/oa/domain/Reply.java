package cn.czk.oa.domain;

public class Reply extends Article{
	private Topic topic;	//主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
