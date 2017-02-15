package init;

import java.lang.reflect.Modifier;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Aspect
@Component
public class LogAspect {
    @Before("execution(* springmvcControl..*.*(..))")  
    public void before(){  
        System.out.println("方法执行前执行111111111111111.....");  
    }  
	   /*  @Autowired private HttpServletRequest request;*/
	    private static Logger logger = Logger.getLogger(LogAspect.class);
	    @AfterReturning(value = "execution(* springmvcControl..*.*(..))", returning = "returnVal")
	    public void afterReturning(JoinPoint point, Object returnVal)
	    {
	        //String requestURL = request.getServletPath();
	        System.out.println("11111111111");
	        //LogAspect.logger.info("-------------------requestURL----is------------>>" + requestURL);
	        //拦截的实体类
	        //LogAspect.logger.info("-------------------ClassName----is------------>>" + point.getThis().getClass().getName());
	        //Object target = point.getTarget();
	        Signature signature = point.getSignature();
	        //拦截的方法名称
	        LogAspect.logger.info("DeclaringType:" + signature.getDeclaringType());
	        //LogAspect.logger.info("DeclaringTypeName:" + signature.getDeclaringTypeName());
	        LogAspect.logger.info("Modifiers:" + Modifier.toString(signature.getModifiers()));
	        LogAspect.logger.info("Method Name:" + signature.getName());
	        LogAspect.logger.info("LongString:" + signature.toLongString());
	        //LogAspect.logger.info("ShortString:" + signature.toShortString());

	        //拦截的方法参数
	        Object[] args = point.getArgs();
	        for (int i = 0; i < point.getArgs().length; i++)
	        {
	            LogAspect.logger.info("-------------------arg----is------------>>" + point.getArgs()[i]);
	        }
	        //拦截的放参数类型
	        /*Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();

	        Method m = null;
	        try
	        {
	            //通过反射获得拦截的method
	            m = target.getClass().getMethod(methodName, parameterTypes);
	            //如果是桥则要获得实际拦截的method
	            if (m.isBridge())
	            {
	                for (int i = 0; i < args.length; i++)
	                {
	                    //获得泛型类型
	                    Class genClazz = ReflectionUtils.getSuperClassGenricType(target.getClass());
	                    //根据实际参数类型替换parameterType中的类型
	                    if (args[i].getClass().isAssignableFrom(genClazz))
	                    {
	                        parameterTypes[i] = genClazz;
	                    }
	                }
	                //获得parameterType参数类型的方法
	                m = target.getClass().getMethod(methodName, parameterTypes);
	            }
	            Annotation[] arr = m.getDeclaredAnnotations();
	            for (int i = 0; i < arr.length; i++)
	            {
	                Annotation annotation = arr[i];
	                if (annotation.annotationType().isAnnotation() && annotation.annotationType().isAssignableFrom(RequestMapping.class))
	                {
	                    LogAspect.logger.info("-------------------annotation---------------->>" + annotation.toString());
	                    RequestMapping mapping = (RequestMapping) annotation;
	                    LogAspect.logger.info("------------------RequestMapping----------------->>" + mapping.toString());
	                    LogAspect.logger.info("------------------RequestMapping----------------->>" + mapping.annotationType());
	                    LogAspect.logger.info("------------------RequestMapping----------------->>" + mapping.value()[0]);
	                }
	            }
	        } catch (SecurityException e)
	        {
	            e.printStackTrace();
	        } catch (NoSuchMethodException e)
	        {
	            e.printStackTrace();
	        }*/
	        LogAspect.logger.info("----------------->>afterReturning executed, return result is====" + returnVal);
	    }
	    @AfterThrowing(value = "execution(* springmvcControl..*.*(..))", throwing = "error")
	    public void afterThrowing(JoinPoint point, Throwable error)
	    {
	         System.out.println("111");
	    }
}
