package cn.czk.oa.dao;

import cn.czk.oa.domain.Forum;

public interface ForumManageDao extends BaseDao<Forum>{
	
	/**
	 * 获取上一层的Forum
	 * @param id
	 * @return
	 */
	Forum getUpForm(int id);

	/**
	 * 获取下一层的Forum
	 * @param id
	 * @return
	 */
	Forum getDownForm(int id);

}
