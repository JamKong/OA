package cn.czk.oa.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5513673061019811381L;

	private Long topicId;

	// 1.添加回复的输入页面
	public String addUI() throws Exception {
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}

	// 2.添加回复
	public String add() throws Exception {
		// 1.表单字段
		// model.setTitle(title); //已经封装好了
		// model.setContent(content); //已经封装好了
		model.setTopic(topicService.getById(topicId));

		// 2.当前信息
		model.setAuthor(getAuthor());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		// 3.业务数据
		// 相关的业务数据都写在replyServiceImpl中的save方法

		// 4.保存
		replyService.save(model);
		return "toTopicShow";
	}

	public String updateUI() {
		model = replyService.getById(model.getId());
		ActionContext.getContext().put("reply", model);
		return "updateUI";
	}

	public String update() {
		Reply reply = replyService.getById(model.getId());
		reply.setContent(model.getContent());
		replyService.update(reply);
		ActionContext.getContext().getValueStack().set("model", reply);
		return "toTopicShow";
	}

	public String delete() {
		model = replyService.getById(model.getId());
		model.setContent("<div>该内容违反了本论坛相关规定，内容已被管理员删除！</div>");
		replyService.update(model);
		return "toTopicShow";
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
