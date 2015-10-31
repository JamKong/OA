package cn.czk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.DepartmentDao;
import cn.czk.oa.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {
	/**
	 * 通过上级部门的id来查找下级的部门
	 * 
	 * @return List<Department>
	 */
	public List<Department> getChildren(Long parentId) {
		return (List<Department>) getSession().createQuery(
				"FROM Department d WHERE d.parent.id = ? ORDER BY d.id")//
				.setParameter(0, parentId)//
				.list();
	}

	/**
	 * 获取最顶层的部门列表
	 * 
	 * @return
	 */
	public List<Department> getTopList() {
		return (List<Department>) getSession().createQuery(
				"FROM Department d WHERE d.parent.id IS NULL ORDER BY d.id")//
				.list();
	}

}
