package springAopTest;


import org.springframework.stereotype.Component;
  
public class testSpringadvice {   
  
    public testSpringadvice(){   
           
    }   
       

    public void sleeppoint(){}   
       
 
    public void beforeSleep(){   
        System.out.println("睡觉前要脱衣服!111");   
    }   
       

    public void afterSleep(){   
        System.out.println("睡醒了要穿衣服！11");   
    }   
       
}  
