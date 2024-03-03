package Chapter3.Object;

public class P3_10 {
	//生产者类
	
	private String lock;
	public P3_10(String lock){
		super();
		this.lock=lock;
	}
	
	public void setValue(){
		try{
			synchronized (lock) {
			    while(!VObject3_10.value.equals("")){
			    	System.out.println(" 生产者"+Thread.currentThread().getName()+"开始等待");
			    	lock.wait();
			    }
			    System.out.println("生产者"+Thread.currentThread().getName()+"开始执行");
			    String value=System.currentTimeMillis()+"_"+System.nanoTime();
			    System.out.println("set 的值是"+value);
			    VObject3_10.value=value;
			    // lock.notify(); 
			    
			   lock.notifyAll();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
