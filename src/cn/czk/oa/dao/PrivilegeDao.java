package cn.czk.oa.dao;

import java.util.List;

import cn.czk.oa.domain.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege>{

	/**
	 * 获取顶级菜单项
	 */
	List<Privilege> findTopList();

}
