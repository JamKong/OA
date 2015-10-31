package cn.czk.oa.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 获取记录列表
	 * @param currentPage
	 * @param pageSize
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public List getRecordList(int currentPage, int pageSize, String hql,
			List parameter);
	
	/**
	 * 获取记录总数量
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public int getRecordCount(String hql, List parameter);

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 按id查询实体
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 查询所有
	 * @return 
	 */
	List<T> findAll();
	/**
	 * 按id数组查询实体集合
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
}
