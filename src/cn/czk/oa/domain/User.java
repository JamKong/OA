package cn.czk.oa.domain;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User {
	private Long id;
	private String username;
	private String password;
	private String description;
	private String name;
	private String gender;
	private String phoneNumber;
	private String email;
	private Set<Role> roles; // 岗位设置
	private Department department; // 所属部门

	/**
	 * 判断当前用户是否为超级管理员
	 * 
	 * @return
	 */
	public boolean isAdmin() {
		if (username.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据传入的权限地址，判断当前用户是否有该权限。
	 * 
	 * @param privilegeUrl
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean hasPrivilegeByUrl(String privilegeUrl) {
		// 判断是否为超级管理员
		if (isAdmin()) {
			return true;
		}
		// 处理Action地址
		// 如果Url不是以“/”开头，那么就加上“/”
		if (!privilegeUrl.startsWith("/")) {
			privilegeUrl = "/" + privilegeUrl; // 给Action地址添加一个"/"
		}
		int pos = privilegeUrl.indexOf("?"); // 去掉地址后面的参数
		if (pos > -1) {
			privilegeUrl = privilegeUrl.substring(0, pos);
		}
		// 如果URL除掉参数后，是以.action结尾的，那么就去除掉.action
		if (privilegeUrl.endsWith(".action")) {
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length() - 7); // 去掉".action"后缀
		}
		// 判断是否以UI后缀结尾
		if (privilegeUrl.endsWith("UI")) { 
			// 是以“UI”作为后缀的话，那么就去除掉“UI”这个后缀
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length() - 2);
		}

		// 判断是否为普通权限，既就是只要登录了都可以访问的权限
		List<Privilege> allPrivilegeList = (List<Privilege>) ActionContext
				.getContext().getApplication().get("allPrivilegeList");
		for (Privilege p : allPrivilegeList) {
			if (privilegeUrl.equals(p.getUrl())) {
				// 是特殊权限，那么就需要判断是否具有该权限。
				if (roles != null) {
					for (Role role : roles) {
						if (role.getPrivileges() != null) {
							for (Privilege privilege : role.getPrivileges()) {
								if (privilegeUrl.equals(privilege.getUrl())) {
									return true;
								}
							}
						}
					}
					return false;
				}
			}
		}
		// 如果请求的Url不是特殊权限，那么就放行
		return true;
	}

	/**
	 * 根据传入的权限名称，判断当前用户是否有该权限。
	 * 
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		if (isAdmin()) {
			return true;
		}
		for (Role role : roles) {
			for (Privilege privilege : role.getPrivileges()) {
				if (privilegeName.equals(privilege.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public String getGender() {
		return gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Department getDepartment() {
		return department;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
