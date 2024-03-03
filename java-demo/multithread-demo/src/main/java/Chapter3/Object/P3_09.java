package Chapter3.Object;

public class P3_09 {
	//生产者
	
	private String lock;
	public P3_09(String lock){
		super();
		this.lock=lock;
	}
	
	public void setValue(){
		try{
			synchronized (lock) {
			    if(!ValueObject3_09.value.equals("")){
			    	lock.wait();
			    }
			    
			    String value=System.currentTimeMillis()+"_"+System.nanoTime();
			    System.out.println("set 的值是"+value);
			    ValueObject3_09.value=value;
			    lock.notify(); 
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
