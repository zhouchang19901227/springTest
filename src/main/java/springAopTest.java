import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springAopTest.Sleepable;

public class springAopTest {

	@Test
	public void test()
	{
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("human");
		sleeper.sleep();   
	}
}
