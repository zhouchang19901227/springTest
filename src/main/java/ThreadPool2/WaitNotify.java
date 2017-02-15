package ThreadPool2;
class NumberPrint implements Runnable{  
    private int number;  
    public byte res[];  
    public static int count = 5;  
    public NumberPrint(int number, byte a[]){  
        this.number = number;  
        res = a;  
    }  
    public void run(){  
        synchronized (res){  
            while(count-- > 0){  
                try {  
                    res.notify();//唤醒等待res资源的线程，把锁交给线程（该同步锁执行完毕自动释放锁）  
                    System.out.println(" "+number);  
                    res.wait();//释放CPU控制权，释放res的锁，本线程阻塞，等待被唤醒。  
                    System.out.println("------线程"+Thread.currentThread().getName()+"获得锁，wait()后的代码继续运行："+number);  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }//end of while  
            return;  
        }//synchronized  
          
    }  
}  
public class WaitNotify {  
    public static void main(String args[]){  
        final byte a[] = {0};//以该对象为共享资源  
        new Thread(new NumberPrint((1),a),"1").start();  
        new Thread(new NumberPrint((2),a),"2").start();  
    }  
}
/**
 * 总结：

    wait()方法与notify()必须要与synchronized(resource)一起使用。
    也就是wait与notify针对已经获取了resource锁的线程进行操作，从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。
    从功能上来说wait()线程在获取对象锁后，主动释放CPU控制权，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。
    相应的notify()就是对对象锁的释放操作。【因此，我们可以发现，wait和notify方法均可释放对象的锁，但wait同时释放CPU控制权，即它后面的代码停止执行，线程进入阻塞状态，
    而notify方法不立刻释放CPU控制权，而是在相应的synchronized(){}语句块执行结束，再自动释放锁。 】释放锁后，JVM会在等待resoure的线程中选取一线程，赋予其对象锁，
    唤醒线程，继续执行。这样就提供了在线程间同步、唤醒的操作。Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，主要的区别在于
    Object.wait()在释放CPU同时，释放了对象锁的控制，而在同步块中的Thread.sleep()方法并不释放锁，仅释放CPU控制权。
 */

