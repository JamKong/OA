package cn.czk.oa.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {

	@SuppressWarnings("unused")
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private Log log = LogFactory.getLog(this.getClass());

	@Test
	public void testLog() throws Exception {
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
}
