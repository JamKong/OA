package cn.czk.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.czk.oa.domain.User;
@Repository
public class DaoTest {
//	@Resource
//	private HibernateTemplate hibernateTemplate;
	@Resource
	private SessionFactory sessionFactory;
	public void save(){
//		hibernateTemplate.save(user);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try{
			session.save(new User());
//			int i = 1/0;
			session.save(new User());
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}
	}
}
