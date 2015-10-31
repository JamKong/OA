package cn.czk.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.czk.oa.dao.UserDao;
import cn.czk.oa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User findByUsernameAndPassword(String username, String password) {
		return (User) getSession().createQuery(
				"FROM User WHERE username = ? AND password = ?")//
				.setParameter(0, username)//
				.setParameter(1, password)//
				.uniqueResult();
	}

}
