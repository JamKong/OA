package cn.czk.oa.dao;

import cn.czk.oa.domain.User;

public interface UserDao extends BaseDao<User>{
	public User findByUsernameAndPassword(String username,String password);
}
