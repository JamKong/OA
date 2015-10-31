package cn.czk.oa.service;

import java.util.List;

import cn.czk.oa.domain.User;


public interface UserService {

	void save(User model);

	void update(User model);

	void delete(Long id);

	List<User> findAll();

	User getById(Long id);

	User findByUsernameAndPassword(String username,String password);


}
