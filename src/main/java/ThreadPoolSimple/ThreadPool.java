package ThreadPoolSimple;

public class ThreadPool {

	  public static void main(String[] args) throws InterruptedException {
	        MyThreadPool pool = new MyThreadPool(3);
	        for(int i = 0;i<10;i++){
	            pool.execute(new Runnable() {
	                @Override
	                public void run() {
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                    }
	                    System.out.println("working...");
	                }
	            });
	        }
	        pool.join();
	        //pool.close();
	    }
}
