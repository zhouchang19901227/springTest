package springAopTest;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice{   
	  
	@Override
	public void before(java.lang.reflect.Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		 System.out.println("通常情况下睡觉之前要脱衣服！"); 
	}  

	@Override
	public void afterReturning(Object arg0, java.lang.reflect.Method arg1, Object[] arg2, Object arg3)
			throws Throwable {
		System.out.println("起床后要先穿衣服！"); 
		
	}

	 
       
}  
