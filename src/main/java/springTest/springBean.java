package springTest;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import entity.hibernate.Person;

public class springBean {
    @Resource(name="sf")
    public SessionFactory sessionFactory;
	public void savePerson() {
	
	}
	// 日志对象
	private static final Logger logger = LoggerFactory.getLogger(springBean.class);
	public springBean()
	{
		savePerson();
		logger.info("ffffffffffffffffffffffff");
       System.out.println("testBean");
	}
	public void transfer(final String out, final String in, final Double money) {


	}
}
