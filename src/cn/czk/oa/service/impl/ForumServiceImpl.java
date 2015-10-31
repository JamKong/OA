package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.ForumDao;
import cn.czk.oa.domain.Forum;
import cn.czk.oa.service.ForumService;
@Service
@Transactional
public class ForumServiceImpl implements ForumService{
	@Resource
	private ForumDao forumDao;

	public void delete(Long id) {
		forumDao.delete(id);
	}

	public List<Forum> findAll() {
		return forumDao.findAll();
	}

	public Forum getById(Long id) {
		return forumDao.getById(id);
	}

	public void save(Forum model) {
		forumDao.save(model);
	}

	public void update(Forum model) {
		forumDao.update(model);
	}

	public List<Forum> getByIds(Long[] forumIds) {
		return forumDao.getByIds(forumIds);
	}
	
	
	
}
