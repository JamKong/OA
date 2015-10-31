package cn.czk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.ForumDao;
import cn.czk.oa.domain.Forum;
@Repository("forumDao")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao{
	
	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("FROM Forum ORDER BY position ASC").list();
	}
}
