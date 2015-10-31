package cn.czk.oa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.ReplyDao;
import cn.czk.oa.domain.Forum;
import cn.czk.oa.domain.PageBean;
import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;
import cn.czk.oa.service.ReplyService;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
	@Resource
	private ReplyDao replyDao;

	public void delete(Long id) {
		replyDao.delete(id);
	}

	public List<Reply> findAll() {
		return replyDao.findAll();
	}

	public Reply getById(Long id) {
		return replyDao.getById(id);
	}

	public void save(Reply model) {
		// 维护相关信息
		Topic topic = model.getTopic();
		Forum forum = topic.getForum();

		forum.setArticleCount(forum.getArticleCount() + 1); // 文章数量（主题数+回复数）
		topic.setLastReply(model); // 回复数量
		topic.setReplyCount(topic.getReplyCount() + 1); // 最后发表的回复
		topic.setLastUpdateTime(model.getPostTime()); // 最后更新的时间

		replyDao.save(model);
	}

	public void update(Reply model) {
		replyDao.update(model);
	}

	public List<Reply> getByIds(Long[] replyIds) {
		return replyDao.getByIds(replyIds);
	}

	/**
	 * 获取topic下reply的集合
	 * 
	 * @param topic
	 * @return
	 */
	@Deprecated
	public List<Reply> getByTopic(Topic topic) {
		return replyDao.getByTopic(topic);
	}
	
	
	public PageBean getPageBeanByTopic(int currentPage, int pageCount,Topic topic) {
		//查询列表
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		List parameters = new ArrayList();
		parameters.add(topic);
		List<Reply> recordList = replyDao.getRecordList(currentPage, pageCount, hql, parameters);
		hql = "SELECT COUNT(*)"+hql.substring(0, hql.indexOf("ORDER"));
		int recordCount = replyDao.getRecordCount(hql, parameters);
		return new PageBean(currentPage, pageCount, recordList, recordCount);
	}

}
