package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.PrivilegeDao;
import cn.czk.oa.domain.Privilege;
import cn.czk.oa.service.PrivilegeService;
@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {
	@Resource
	private PrivilegeDao privilegeDao;
	
	public void delete(Long id) {
		if(id!=null){
			privilegeDao.delete(id);
		}
	}

	public List<Privilege> findAll() {
		return privilegeDao.findAll();
	}

	public Privilege getById(Long id) {
		return privilegeDao.getById(id);
	}

	public void save(Privilege model) {
		privilegeDao.save(model);
	}

	public void update(Privilege model) {
		privilegeDao.update(model);
	}

	public List<Privilege> getByIds(Long[] privilegeIds) {
		return privilegeDao.getByIds(privilegeIds);
	}

	/**
	 * 获取顶级菜单项
	 */
	public List<Privilege> findTopList() {
		return privilegeDao.findTopList();
	}

	public List<Privilege> getAllPrivilegeList() {
		return privilegeDao.findAll();
	}
	
}
