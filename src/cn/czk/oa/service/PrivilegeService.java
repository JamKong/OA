package cn.czk.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.domain.Privilege;

@Service
@Transactional
public interface PrivilegeService extends BaseService<Privilege>{

	public List<Privilege> getByIds(Long[] privilegeIds);

	/**
	 * 获取顶级菜单项
	 */
	public List<Privilege> findTopList();

	public List<Privilege> getAllPrivilegeList();

}
