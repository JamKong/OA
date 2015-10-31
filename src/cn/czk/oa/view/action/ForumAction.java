package cn.czk.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.PageBean;
import cn.czk.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7922574578045603992L;
	
	private Long forumId;
	// 1.获取板块列表页面
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	// 2.获取单个板块的内容页面
	public String show() throws Exception {
		//1.获取所属板块
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		//2.该板块下的主题集合
		List<Topic> topicList = topicService.getByForum(forum); //通过所属的板块对象，获取得到该板块下的主题集合
		ActionContext.getContext().put("topicList", topicList);
		//获取分页数据
//		PageBean pageBean = topicService.getPageBeanByTopic(currentPage, pageSize, topic);
//		ActionContext.getContext().getValueStack().push(pageBean);
		return "show";
	}

	
	// get set
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
}
