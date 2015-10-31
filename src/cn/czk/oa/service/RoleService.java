package cn.czk.oa.service;

import java.util.List;

import cn.czk.oa.domain.Role;


public interface RoleService extends BaseService<Role>{
	
	public List<Role> getByIds(Long[] roleIds);
}
