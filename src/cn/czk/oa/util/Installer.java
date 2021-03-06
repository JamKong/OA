package cn.czk.oa.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.domain.Privilege;
import cn.czk.oa.domain.User;
@Component
public class Installer {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 安装/初始化数据
	 */
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		//保存超级管理员用户
		User user = new User();
		user.setUsername("admin");
		user.setName("超级管理员");
		user.setPassword(DigestUtils.md5Hex("admin")); //初始化密码为admin
		session.save(user);
		
		//保存权限数据
		Privilege menu,menu1,menu2,menu3,menu4,menu5;
		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/role_list", menu);
		menu2 = new Privilege("部门管理", "/department_list", menu);
		menu3 = new Privilege("用户管理", "/user_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		                          
		session.save(new Privilege("岗位列表", "/role_list", menu1));
		session.save(new Privilege("岗位添加", "/role_add", menu1));
		session.save(new Privilege("岗位修改", "/role_update", menu1));
		session.save(new Privilege("岗位删除", "/role_delete", menu1));
		session.save(new Privilege("设置权限", "/role_setPrivilege", menu1));
		                          
		session.save(new Privilege("部门列表", "/department_list", menu2));
		session.save(new Privilege("部门添加", "/department_add", menu2));
		session.save(new Privilege("部门修改", "/department_update", menu2));
		session.save(new Privilege("部门删除", "/department_delete", menu2));
		                          
		session.save(new Privilege("用户列表", "/user_list", menu3));
		session.save(new Privilege("用户添加", "/user_add", menu3));
		session.save(new Privilege("用户修改", "/user_update", menu3));
		session.save(new Privilege("用户删除", "/user_delete", menu3));
		session.save(new Privilege("初始化密码", "/user_initPassword", menu3));
		
		menu = new Privilege("网上交流", null, null);
		menu1 = new Privilege("论坛", "/forum_list", menu);
		menu2 = new Privilege("论坛管理", "/forumManage_list", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		
		session.save(new Privilege("主题列表", "/forum_show", menu1));
		session.save(new Privilege("添加主题", "/topic_add", menu1));
		session.save(new Privilege("修改主题", "/topic_update", menu1));
		session.save(new Privilege("删除主题", "/topic_delete", menu1));
		//主题浏览
		session.save(new Privilege("主题加精", "/topic_delete", menu1));
		session.save(new Privilege("主题置顶", "/topic_delete", menu1));
		session.save(new Privilege("主题普通", "/topic_delete", menu1));
		//移动主题到其它板块
		session.save(new Privilege("主题移动", "/topic_moveUI", menu1));
		
		session.save(new Privilege("添加回复", "/reply_add", menu1));
		session.save(new Privilege("修改回复", "/reply_update", menu1));
		session.save(new Privilege("删除回复", "/reply_delete", menu1));
		
		
		session.save(new Privilege("添加板块", "/forumManage_add", menu2));
		session.save(new Privilege("修改板块", "/forumManage_update", menu2));
		session.save(new Privilege("删除板块", "/forumManage_delete", menu2));
		session.save(new Privilege("上移板块", "/forumManage_moveUp", menu2));
		session.save(new Privilege("下移板块", "/forumManage_moveDown", menu2));
		
		
		
		menu = new Privilege("审批流转", null, null);
		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
		menu2 = new Privilege("申请模板管理", "/template_list", menu);
		menu3 = new Privilege("起草申请", "/flow_templateList", menu);
		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(menu5);
	}  
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) applicationContext.getBean("installer");
		installer.install();
		
	}
}
