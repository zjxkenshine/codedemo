package Chapter3.Object;

public class C3_09 {
	//消费者
	
	private String lock;
	public C3_09(String lock){
		super();
		this.lock=lock;
	}
	
	public void getValue(){
		try{
			synchronized (lock) {
			    if(ValueObject3_09.value.equals("")){
			    	lock.wait();
			    }
			    System.out.println("get 的值是"+ValueObject3_09.value);
			    ValueObject3_09.value="";
			    lock.notify(); 
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
