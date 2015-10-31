package cn.czk.oa.service;

import java.util.List;

import cn.czk.oa.domain.Department;

public interface DepartmentService extends BaseService<Department>{

	/**
	 * 通过上级部门的id来查找下级的部门
	 * @return List<Department>
	 */
	List<Department> getChildren(Long parentId); 
	/**
	 * 获取最顶层的部门列表
	 * @return
	 */
	List<Department> getTopList();
	

}
