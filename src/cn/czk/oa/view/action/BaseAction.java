package cn.czk.oa.view.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.czk.oa.domain.User;
import cn.czk.oa.service.DepartmentService;
import cn.czk.oa.service.ForumManageService;
import cn.czk.oa.service.ForumService;
import cn.czk.oa.service.PrivilegeService;
import cn.czk.oa.service.ReplyService;
import cn.czk.oa.service.RoleService;
import cn.czk.oa.service.TopicService;
import cn.czk.oa.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3786164676661775110L;
	protected T model;
	private Class<T> clazz;

	/**
	 * 通过反射技术获取T的真实类型
	 * 注意：范式应该在编译的时候就指定，而不是运行时。
	 */
	@SuppressWarnings("unchecked")
	public BaseAction() {
		try{
			Class c = this.getClass();
			Type t = c.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
	            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
	            this.clazz = (Class<T>) p[0];
	            model = clazz.newInstance();
	        }
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	public T getModel() {
		return model;
	}
	
	
	protected User getAuthor() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected UserService userService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumManageService forumManageService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	
	
}
