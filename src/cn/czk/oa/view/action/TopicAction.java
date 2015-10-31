package cn.czk.oa.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.PageBean;
import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3701171824781708752L;

	private Long forumId;
	private int currentPage = 1;
	private int pageSize = 10;

	/**
	 * 修改主题的类型
	 * 
	 * @return
	 */
	public String editType() {
		Topic topic = topicService.getById(model.getId());
		topic.setType(model.getType());
		topicService.update(topic);
		ActionContext.getContext().getValueStack().set("model", topic);
		return "toShow";
	}

	// 1.显示单个主题页面
	public String show() throws Exception {
		// 1.准备数据 topic
		model = topicService.getById(model.getId());
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		// 2.准备数据 replyList(旧,已被下面的代码替代)
		// List<Reply> replyList = replyService.getByTopic(topic);
		// ActionContext.getContext().put("replyList", replyList);
	
		//准备分页数据
		PageBean pageBean = replyService.getPageBeanByTopic(currentPage, pageSize, topic);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}

	// 2.添加一个新主题的页面
	public String addUI() throws Exception {
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}

	/**
	 * 3.发表新主题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		// * 需要注意的特殊属性
		// * 回复总数 || replyCount || 0(默认值)
		// * 最新回复 || lastReply || Null(默认值)
		// * 最新更新时间 || lastUpdateTime || 当前该主题的发表时间
		// * 主题总数 || topicCount || +1
		// * 文章总数 || articleCount || +1

		// 1.获取所隶属的板块
		Forum forum = forumService.getById(forumId);
		// 2.给新主题赋值
		model.setForum(forum);

		model.setAuthor(getAuthor()); // getAuthor()获取当前用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());

		model.setType(Topic.TYPE_NORMAL);
		model.setLastReply(null);
		model.setReplyCount(0);
		model.setLastUpdateTime(model.getPostTime());
		// 3.保存到数据库
		topicService.save(model);
		// 4.给该板块赋值，并更新
		forum.setLastTopic(model);
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setTopicCount(forum.getTopicCount() + 1);
		forumService.update(forum);
		// 5.准备数据 model
		ActionContext.getContext().put("model", model);
		return "toShow";
	}

	public String updateUI() {
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		return "editUI";
	}

	public String update() {
		Topic topic = topicService.getById(model.getId());
		topic.setTitle(model.getTitle());
		topic.setContent(model.getContent());
		topicService.update(topic);
		ActionContext.getContext().put("model", topic);
		return "toShow";
	}

	public String delete() {
		Topic topic = topicService.getById(model.getId());
		topic.setLastReply(null);// 设置最后回复为空，解除外键约束
		// 删除关联的回复
		List<Reply> replyList = new ArrayList<Reply>(topic.getReplies());
		for (Reply reply : replyList) {
			reply.setAuthor(null);
			reply.setTopic(null);
			replyService.delete(reply.getId());
		}
		Forum forum = topic.getForum();
		int articleCount = forum.getArticleCount() - replyList.size() - 1;// 减去这次删除掉得文章数
		forum.setArticleCount(articleCount); // 更新文章数
		forum.setTopicCount(forum.getTopicCount() - 1);// 更新主题数
		forum.getTopics().remove(topic);// 移除掉要被删除的主题
		// 更新Forum的最后发表Topic
		List<Topic> topicList = topicService.getTopicList(forum);
		Topic lastTopic = null;
		if (topicList.size() >= 1) {
			lastTopic = topicList.get(0);
		}
		forum.setLastTopic(lastTopic);

		topic.setAuthor(null);// 设置作者为空
		topic.setForum(null);// 设置关联的主题为空
		topicService.delete(topic.getId());

		ActionContext.getContext().getValueStack().set("forum", forum);// 传递forumId给forum_show.action
		return "toForumShow";
	}

	// get set
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
