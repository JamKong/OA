package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.RoleDao;
import cn.czk.oa.domain.Role;
import cn.czk.oa.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleDao roleDao;

	public void delete(Long id) {
		roleDao.delete(id);
	}

	public List<Role> findAll() {
		return roleDao.findAll();
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void save(Role model) {
		roleDao.save(model);
	}

	public void update(Role model) {
		roleDao.update(model);
	}

	public List<Role> getByIds(Long[] roleIds) {
		return roleDao.getByIds(roleIds);
	}
	
	
	
}
