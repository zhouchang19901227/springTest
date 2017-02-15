package springAopTest;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect  
public class testanotaionAop {   
  
    public testanotaionAop(){   
           
    }   
       
    @Pointcut("execution(* *.sleep())")   
    public void sleeppoint(){}   
       
    @Before("sleeppoint()")   
    public void beforeSleep(){   
        System.out.println("睡觉前要脱衣服!222");   
    }   
       
    @AfterReturning("sleeppoint()")   
    public void afterSleep(){   
        System.out.println("睡醒了要穿衣服！22222");   
    }   
       
}  
