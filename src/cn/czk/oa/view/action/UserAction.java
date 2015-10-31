package cn.czk.oa.view.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Department;
import cn.czk.oa.domain.Role;
import cn.czk.oa.domain.User;
import cn.czk.oa.util.DepartmentUtil;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5149294764014879991L;
	
	private Long parentId;
	private Long[] roleIds;

	public String addUI() {
		// 1. 获取最顶级的部门
		List<Department> departmentList = departmentService.getTopList();
		// 2. 获取所有部门的子部门等，并以树状的结构保存到list集合中
		departmentList = DepartmentUtil.getAllDepartments(departmentList);
		// 3. 保存到已经处理过的list集合
		ActionContext.getContext().put("departmentList", departmentList);

		// 4. 获取岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		return "addUI";
	}

	public String add() {
		List<Role> roleList = roleService.getByIds(roleIds);
		Set<Role> roles = new HashSet<Role>(roleList);
		Department parent = departmentService.getById(parentId);
		model.setRoles(roles);
		model.setDepartment(parent);
		userService.save(model);
		return "toList";
	}

	public String updateUI() {
		// 1. 获取最顶级的部门
		List<Department> departmentList = departmentService.getTopList();
		// 2. 获取所有部门的子部门等，并以树状的结构保存到list集合中
		departmentList = DepartmentUtil.getAllDepartments(departmentList);
		// 3. 保存到已经处理过的list集合
		ActionContext.getContext().put("departmentList", departmentList);

		// 4. 获取岗位列表
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);

		model = userService.getById(model.getId()); // 获取要更新的User对象
		// 5. 获取该User对象的所属部门对象
		Department parent = model.getDepartment();
		ActionContext.getContext().put("parent", parent);
		// 6. 获取该User对象的岗位
		if (model.getRoles() != null) {
			roleIds = new Long[model.getRoles().size()];
			int index = 0;
			for(Role role : model.getRoles()){
				roleIds[index++] = role.getId();
			}
		}

		List<Role> roles = new ArrayList<Role>(model.getRoles());
		ActionContext.getContext().put("roles", roles);
		ActionContext.getContext().put("user", model);
		return "updateUI";
	}

	public String update() {
		User user = userService.getById(model.getId());
		user.setName(model.getName());
		user.setUsername(model.getUsername());
		user.setGender(model.getGender());
		user.setEmail(model.getEmail());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setDescription(model.getDescription());
		user.setDepartment(model.getDepartment());
		List<Role> roleList = roleService.getByIds(roleIds);	
		user.setRoles(new HashSet<Role>(roleList));	//把list集合转换成Set
		
		userService.update(user);
		return "toList";
	}

	public String delete() {
		userService.delete(model.getId());
		return "toList";
	}

	public String list() {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}
	
	/**
	 * 初始化密码
	 * @return
	 */
	public String initPassword(){
		User user = userService.getById(model.getId());
		String md5Digest = DigestUtils.md5Hex("1234"); //使用md5加密  ，需要导入commons-codec.jar包
		user.setPassword(md5Digest);
		userService.update(user);
		return "toList";
	}
	/**
	 * 登录界面
	 * @return
	 */
	public String loginUI() {
		return "loginUI";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		String md5Digest = DigestUtils.md5Hex(model.getPassword()); //使用md5加密摘要
		model =  userService.findByUsernameAndPassword(model.getUsername(), md5Digest);
		if(model!=null){
			ActionContext.getContext().getSession().put("user", model);
			return "index";
		}else{ 
			ActionContext.getContext().put("error", "帐号或密码错误！");
			return "errorUI"; 
		}
	}
	/**
	 * 注销
	 * @return
	 */
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}
	
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

}
