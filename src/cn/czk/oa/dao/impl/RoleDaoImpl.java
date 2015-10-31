package cn.czk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.RoleDao;
import cn.czk.oa.domain.Role;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
