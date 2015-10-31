package cn.czk.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.czk.oa.domain.User;
@Service("serviceTest")
@Transactional
public class ServiceTest {
	@Resource
	private SessionFactory sessionFactory;
	
	public void save(){
		Session session = sessionFactory.getCurrentSession();
		session.save(new User());
		session.save(new User());
	}
}
