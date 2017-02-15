import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import entity.hibernate.Person;
import springTest.springBean;

@ContextConfiguration(locations = { "/spring.xml" })

public class HibernateTest extends AbstractJUnit4SpringContextTests{



    @Resource(name="sf")

    public SessionFactory sessionFactory;

    //@Resource(name="test1")

    //public springBean sessionFactory;
   

    @Test

    public void testApp(){

    System.out.println(sessionFactory);
    Session session = sessionFactory.openSession();  
    session.beginTransaction();
  
	Person p =new Person();
	p.setId("12");
	p.setName("3232323");
	p.setAddress("dsdfsd");
	session.save(p);
	session.getTransaction().commit();  
	session.close();  


    } 

}