package cn.czk.oa.util;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.czk.oa.domain.Privilege;
import cn.czk.oa.service.PrivilegeService;

public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {

	}
	/**
	 * 创建容器的时候就准备好数据
	 */
	public void contextInitialized(ServletContextEvent sce) {
		//获取当前的容器对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		//获取当前容器对象的privilegeService对象
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		//准备数据；
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		//保存数据；这里不能使用ActionContext保存数据，会报空指针异常，因为这里并不是Struts2的环境下，所以不能使用ActionContext
		sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		
		//准备数据；获取所有需要管理的权限，也就是数据库中的权限。
		List<Privilege> allPrivilegeList = privilegeService.getAllPrivilegeList();
		//保存数据；
		sce.getServletContext().setAttribute("allPrivilegeList", allPrivilegeList);
		
	}

}
