package cn.czk.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringTest {
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	
}
