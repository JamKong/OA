package cn.czk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.ForumManageDao;
import cn.czk.oa.domain.Forum;

@Repository("forumManageDao")
public class ForumManageDaoImpl extends BaseDaoImpl<Forum> implements
		ForumManageDao {
	
	/**
	 * 覆写父类的findAll,使其能够按position字段排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum ORDER BY position").list();
		
	}
	/**
	 * 获取上一层的Forum
	 * 
	 * @param id
	 * @return
	 */
	public Forum getUpForm(int id) {
		return (Forum) getSession().createQuery(
				"FROM Forum WHERE position < ? ORDER BY position DESC")//
				.setParameter(0, id)//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}

	/**
	 * 获取下一层的Forum
	 * 
	 * @param id
	 * @return
	 */
	public Forum getDownForm(int id) {
		return (Forum) getSession().createQuery(
				"FROM Forum WHERE position > ? ORDER BY position ASC")//
				.setParameter(0, id)//
				.setFirstResult(0)//
				.setMaxResults(1)// 
				.uniqueResult();
	}
}
