package cn.czk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.PrivilegeDao;
import cn.czk.oa.domain.Privilege;
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{
	
	/**
	 * 获取顶级菜单项
	 */
	public List<Privilege> findTopList() {
		return getSession().createQuery("FROM Privilege p WHERE p.parent IS NULL").list();
	}

}
