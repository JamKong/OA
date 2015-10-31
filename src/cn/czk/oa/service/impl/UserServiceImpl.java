package cn.czk.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.dao.UserDao;
import cn.czk.oa.domain.User;
import cn.czk.oa.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public void delete(Long id) {
		userDao.delete(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}

	public void save(User model) {
		userDao.save(model);
	}

	public void update(User model) {
		userDao.update(model);
	}

	public User findByUsernameAndPassword(String username,String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}

	
}
