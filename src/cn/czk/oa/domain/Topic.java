package cn.czk.oa.domain;

import java.util.Date;
import java.util.Set;

public class Topic extends Article {
	//普通贴
	public static final int TYPE_NORMAL = 0;
	//精华帖
	public static final int TYPE_BEST = 1;
	//置顶贴
	public static final int TYPE_TOP = 2;

	private Forum forum; // 所属板块
	private int type; // 主题类型，如：置顶、加精
	private int replyCount; // 回复总数
	private Set<Reply> replies; // 隶属该主题的回复集合
	private Reply lastReply; // 最新回复
	private Date lastUpdateTime;// 最近更新时间；如果是没有回复的新帖，那么lastUpdateTime的值就是主题的postTime(在父类)，如果有回复了，那么lastUpdateTime的值就是最新回复的postTime的值

	public Forum getForum() {
		return forum;
	}

	public int getType() {
		return type;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
