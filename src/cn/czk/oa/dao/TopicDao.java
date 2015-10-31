package cn.czk.oa.dao;

import java.util.List;

import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.Topic;

public interface TopicDao extends BaseDao<Topic>{
	/**
	 * 通过所属的板块对象，获取该板块下的主题集合
	 * @param forum
	 * @return
	 */
	List<Topic> getByForum(Forum forum);
	/**
	 * 查找Forum的Topic集合，Topic集合是按发表时间的降序来排的
	 * @param forum
	 * @return
	 */
	List<Topic> getTopicList(Forum forum);

}
