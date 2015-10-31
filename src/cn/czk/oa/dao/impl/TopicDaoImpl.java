package cn.czk.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.TopicDao;
import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.Topic;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {
	/**
	 * 通过所属的板块对象，获取该板块下的主题集合
	 * 
	 * @param forum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Topic> getByForum(Forum forum) {
		return getSession()
				.createQuery(
						"FROM Topic t WHERE t.forum = ? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC ")//
				.setParameter(0, forum)//
				.list();
	}

	/**
	 * 查找Forum的Topic集合，Topic集合是按发表时间的降序来排的
	 * 
	 * @param forum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Topic> getTopicList(Forum forum) {
		return getSession().createQuery(
				"FROM Topic t WHERE t.forum=? ORDER BY t.postTime DESC")
				.setParameter(0, forum).list();

	}

}
