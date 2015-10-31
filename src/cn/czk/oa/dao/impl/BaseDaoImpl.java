package cn.czk.oa.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.BaseDao;

@SuppressWarnings("unchecked")
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	/**
	 * 通过反射技术获取T的真实类型
	 * 注意：范式应该在编译的时候就指定，而不是运行时。
	 */
	public BaseDaoImpl() {
		Class c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
//          System.out.println("in if");
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
//          System.out.println(Arrays.toString(p));
            this.clazz = (Class<T>) p[0];
//          System.out.println(clazz);
        }
	}

	
	/**
	 * 分页：获取当前页的记录数
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public List getRecordList(int currentPage, int pageSize, String hql,
			List parameter) {
		Query query = getSession().createQuery(hql);
		if (parameter != null) {
			for (int i = 0; i < parameter.size(); i++) {
				query.setParameter(i, parameter.get(i));
			}
		}
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 分页：获取主题下的总回复数
	 * 
	 * @param hql
	 * @param parameter
	 * @return
	 */
	public int getRecordCount(String hql, List parameter) {
		Query query = getSession().createQuery(hql);
		if (parameter != null) {
			for (int i = 0; i < parameter.size(); i++) {
				query.setParameter(i, parameter.get(i));
			}
		}
		return ((Long) query.uniqueResult()).intValue();
	}
	/**
	 * 获取当前可用的Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}

	public List<T> findAll() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
	}

	public T getById(Long id) {
		if(id==null){
			return null;
		}else{
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {
		if(ids==null || ids.length ==0){
			return Collections.EMPTY_LIST;  //返回一个空list集合
		}
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " WHERE id IN (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	
	
}
