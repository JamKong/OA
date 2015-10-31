package cn.czk.oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.ReplyDao;
import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;

@Repository("replyDao")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao {


	@SuppressWarnings("unchecked")
	@Deprecated
	public List<Reply> getByTopic(Topic topic) {
		return getSession()//
				.createQuery(//
						"FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)//
				.list();
	}

	@Override
	public void save(Reply model) {
		getSession().save(model);
	}

}
