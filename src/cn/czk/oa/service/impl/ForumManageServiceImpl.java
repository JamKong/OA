package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.ForumManageDao;
import cn.czk.oa.domain.Forum;
import cn.czk.oa.service.ForumManageService;
@Service
@Transactional
public class ForumManageServiceImpl implements ForumManageService {
	@Resource
	private ForumManageDao forumManageDao;

	public void delete(Long id) {
		forumManageDao.delete(id);
	}

	public List<Forum> findAll() {
		return forumManageDao.findAll();
	}

	public Forum getById(Long id) {
		return forumManageDao.getById(id);
	}

	public void save(Forum model) {
		forumManageDao.save(model);
	}

	public void update(Forum model) {
		forumManageDao.update(model);
	}

	public List<Forum> getByIds(Long[] forumIds) {
		return forumManageDao.getByIds(forumIds);
	}
	/**
	 * 上移
	 */
	public void moveUp(Long id) {
		//当前要移动的Forum
		Forum currentForum = forumManageDao.getById(id);
		//当前要移动Forum的上面的Forum
		Forum upForum = forumManageDao.getUpForm(currentForum.getPosition());
		//最上层的Forum不能移动
		if(upForum != null){
			//交换position的值
			int temp = currentForum.getPosition();
			currentForum.setPosition(upForum.getPosition());
			upForum.setPosition(temp);
			forumManageDao.update(currentForum);
			forumManageDao.update(upForum);
		}
	}
	/**
	 * 下移
	 */
	public void moveDown(Long id) {
		//当前要移动的Forum
		Forum currentForum = forumManageDao.getById(id);
		//当前要移动Forum的下面的Forum
		Forum downForum = forumManageDao.getDownForm(currentForum.getPosition());
		//最下层的Forum不能移动
		if(downForum != null){
			//交换position的值
			int temp = currentForum.getPosition();
			currentForum.setPosition(downForum.getPosition());
			downForum.setPosition(temp);
			forumManageDao.update(currentForum);
			forumManageDao.update(downForum);
		}
	}
	
	
	
}
