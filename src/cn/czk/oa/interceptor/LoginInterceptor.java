package cn.czk.oa.interceptor;

import cn.czk.oa.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6375274533049688455L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();	
		String actionName = invocation.getProxy().getActionName();
		String priUrl = namespace + actionName; // 请求的URL地址
		//如果请求的Action是登录，那么就放行;如果登录都不放行的话，那么就没人能登录成功了
		if ("user_login".equals(actionName)) {
			return invocation.invoke();
		}else{
			if (null == user) {
				// 没登录，返回登录界面
				return "loginUI";
			} else {
				// 如果已登录，那么判断用户是否有权限访问
				if (user.hasPrivilegeByUrl(priUrl)) {
					// 有权限，就放行
					return invocation.invoke();
				} else {
					// 没权限，传到错误页面
					return "notPrivilege";
				}
			}
		}
	}

}
