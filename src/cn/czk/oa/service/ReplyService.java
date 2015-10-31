package cn.czk.oa.service;

import java.util.List;

import cn.czk.oa.domain.PageBean;
import cn.czk.oa.domain.Reply;
import cn.czk.oa.domain.Topic;


public interface ReplyService extends BaseService<Reply>{
	/**
	 * 获取topic下reply的集合
	 * @param topic
	 * @return
	 */
	List<Reply> getByTopic(Topic topic);
	
	PageBean getPageBeanByTopic(int currentPage, int pageSize,Topic topic);
}
