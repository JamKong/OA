package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.TopicDao;
import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.Topic;
import cn.czk.oa.service.TopicService;
@Service
@Transactional
public class TopicServiceImpl implements TopicService{
	@Resource
	private TopicDao topicDao;

	public void delete(Long id) {
		topicDao.delete(id);
	}

	public List<Topic> findAll() {
		return topicDao.findAll();
	}

	public Topic getById(Long id) {
		return topicDao.getById(id);
	}

	public void save(Topic model) {
		topicDao.save(model);
	}

	public void update(Topic model) {
		topicDao.update(model);
	}

	public List<Topic> getByIds(Long[] topicIds) {
		return topicDao.getByIds(topicIds);
	}
	
	
	/**
	 * 通过所属的板块对象，获取该板块下的主题集合
	 * @param forum
	 * @return
	 */
	public List<Topic> getByForum(Forum forum) {
		return topicDao.getByForum(forum);
	}
	/**
	 * 查找Forum的Topic集合，Topic集合是按发表时间的降序来排的
	 * @param forum
	 * @return
	 */
	public List<Topic> getTopicList(Forum forum) {
		return topicDao.getTopicList(forum);
	}
	
	
	
}
