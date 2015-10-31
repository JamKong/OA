package cn.czk.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Forum;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 794957495802851305L;

	public String addUI() {
		return "addUI";
	}

	public String add() {
		forumManageService.save(model);
		model.setPosition(model.getId().intValue());
		forumManageService.update(model);//可以不写，因为model被save()后就变成持久化对象，所以它会自动更新
		return "toList";
	}

	public String updateUI() {
		model = forumManageService.getById(model.getId());
		ActionContext.getContext().put("forum", model);
		return "updateUI";
	}

	public String update() {
		Forum forum = forumManageService.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumManageService.update(forum);
		return "toList";
	}

	public String delete() {
		forumManageService.delete(model.getId());
		return "toList";
	}

	public String list() {
		List<Forum> list = forumManageService.findAll();
		ActionContext.getContext().put("list", list);
		return "list";
	}
	/**
	 * 上移
	 * @return
	 */
	public String moveUp(){
		forumManageService.moveUp(model.getId());
		return "toList";
	}
	
	/**
	 * 下移
	 * @return
	 */
	public String moveDown(){
		forumManageService.moveDown(model.getId());
		return "toList";
	}


}
