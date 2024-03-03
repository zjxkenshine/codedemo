package Chapter3.Object;

public class C3_10 {
	//消费者类
	
	private String lock;
	public C3_10(String lock){
		super();
		this.lock=lock;
	}
	
	public void getValue(){
		try{
			synchronized (lock) {
			    while(VObject3_10.value.equals("")){
			    	System.out.println(" 消费者"+Thread.currentThread().getName()+"开始等待");
			    	lock.wait();
			    }
			    System.out.println("消费者"+Thread.currentThread().getName()+"开始执行");
			    System.out.println("get 的值是"+VObject3_10.value);
			    VObject3_10.value="";
			    //lock.notify(); 
			    
			    lock.notifyAll();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
