package cn.czk.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.czk.oa.domain.Department;

public class DepartmentUtil {
	/**
	 * 
	 * @param topList
	 *            指的是需要进行处理成树状结构的集合
	 * @param prefix
	 *            指的是要添加的分隔字符
	 * @return
	 */
	public static List<Department> getAllDepartments(
			Collection<Department> topList) {
		List<Department> list = new ArrayList<Department>();
		walkDepartmentTreeList(topList, "┣", list);
		return list;
	}
	/**
	 * 遍历部门树，并把遍历出的部门信息保存到指定的集合中
	 * @param topList
	 * @param prefix
	 * @param list
	 */
	private static void walkDepartmentTreeList(Collection<Department> topList,
			String prefix, List<Department> list) {
		for (Department top : topList) {
			Department top_ = new Department();
			top_.setId(top.getId());
			top_.setName(prefix + top.getName());// 加上特殊字符的名字
			list.add(top_);
			//为什么使用下面注释掉得的语句就会出现多个"┣"？？？
//			top.setName(prefix+top.getName());
//			list.add(top);
			// " "+prefix 是要让每多一级别就让prefix多加个空格，使得看起来想向右缩进的样子
			walkDepartmentTreeList((Collection<Department>) top.getChildrens(),
					"　" + prefix, list);
		}
	}
}
