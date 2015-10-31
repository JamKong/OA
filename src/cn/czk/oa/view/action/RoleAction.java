package cn.czk.oa.view.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.czk.oa.domain.Privilege;
import cn.czk.oa.domain.Role;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 权限id数组
	private Long[] privilegeIds;

	public String addUI() {
		return "addUI";
	}

	public String add() {
		roleService.save(model);
		return "toList";
	}

	public String updateUI() {
		model = roleService.getById(model.getId());
		ActionContext.getContext().put("role", model);
		return "updateUI";
	}

	public String update() {
		roleService.update(getModel());
		return "toList";
	}

	public String delete() {
		roleService.delete(model.getId());
		return "toList";
	}

	public String list() {
		List<Role> list = roleService.findAll();
		ActionContext.getContext().put("list", list);
		return "list";
	}

	// 设置权限界面
	public String setPrivilegeUI() {
		// 1. 获取当前岗位对象
		model = roleService.getById(model.getId());
		// 2. 获取当前岗位对象的权限
		List<Privilege> privileges = new ArrayList<Privilege>(model.getPrivileges());
		// 3. 保存当前岗位对象的权限的id
		if (privileges != null) {
			int index = 0;
			privilegeIds = new Long[privileges.size()];
			for(Privilege prv : privileges){
				privilegeIds[index++] = prv.getId();  
			}
		}
		ActionContext.getContext().put("privilegeIds", privilegeIds);
		// 4. 获取所有权限列表
		List<Privilege> privilegeList = privilegeService.findAll();
		// 5. 保存所有权限
		ActionContext.getContext().put("privilegeList", privilegeList);
		// 6. 保存岗位对象
		ActionContext.getContext().put("role", model);
		return "setPrivilegeUI";
	}

	// 设置权限
	public String setPrivilege() {
		// 1. 获取选中的权限集合
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		// 2. 赋值给该role对象
		Role role = roleService.getById(model.getId());
		// 3. 更新role
		role.setPrivileges(new HashSet<Privilege>(privilegeList)); // 把List集合转换成Set集合
		roleService.update(role);
		return "toList";
	}

	// ----Set() Get();
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
