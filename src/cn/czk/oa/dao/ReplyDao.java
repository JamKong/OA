package cn.czk.oa.dao;

import java.util.List;

import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;

public interface ReplyDao extends BaseDao<Reply> {
	/**
	 * 获取topic下reply的集合
	 * 
	 * @param topic
	 * @return
	 */
	List<Reply> getByTopic(Topic topic);
}
