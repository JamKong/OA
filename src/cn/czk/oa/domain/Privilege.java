package cn.czk.oa.domain;

import java.util.Set;

/**
 * 权限
 * @author Administrator
 *
 */
public class Privilege {
	private Long id;
	private String name;
	private String url;
	private String description;
	private Set<Role> roles;
	private Privilege parent;
	private Set<Privilege> childrens;
	
	public Privilege() {
	}
	public Privilege(String name, String url,
			Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	public Privilege(String url) {
		this.url = url;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Set<Role> getRoles() {
		return roles;
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
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege getParent() {
		return parent;
	}
	public Set<Privilege> getChildrens() {
		return childrens;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public void setChildrens(Set<Privilege> childrens) {
		this.childrens = childrens;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
