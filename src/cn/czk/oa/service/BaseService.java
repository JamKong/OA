package cn.czk.oa.service;

import java.util.List;

public interface BaseService<T> {

	void save(T model);

	void update(T model);

	void delete(Long id);

	List<T> findAll();

	T getById(Long id);
	
}
