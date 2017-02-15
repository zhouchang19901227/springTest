package springAopTest;


import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("myAdvice")//如果是自动装配,在定义切面的时候直接写在ref属性里就可以了
public class MyAdvice implements MethodBeforeAdvice{
    //如果使用aop:advisor配置,那么切面逻辑必须要实现advice接口才行!否则会失败!
	@Override
	public void before(java.lang.reflect.Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		   System.out.println("前置通知");
	}
    public void doBefore(JoinPoint point) throws Throwable {

    }
}