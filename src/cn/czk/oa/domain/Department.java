package cn.czk.oa.domain;

import java.util.Set;

public class Department {
	private Long id;
	private String name;
	private String description;
	private Set<User> users;
	private Department parent;
	private Set<Department> childrens;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public Department getParent() {
		return parent;
	}
	public Set<Department> getChildrens() {
		return childrens;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	public void setChildrens(Set<Department> childrens) {
		this.childrens = childrens;
	}
	
}
