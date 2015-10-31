package cn.czk.oa.service;

import cn.czk.oa.domain.Forum;


public interface ForumManageService extends BaseService<Forum>{

	void moveDown(Long id);

	void moveUp(Long id);

}
