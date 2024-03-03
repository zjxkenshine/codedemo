package Chapter2.Thread;

import Chapter2.Object.Object2_16_2;
import Chapter2.Object.Service2_16_2;

public class Thread2_16_2B extends Thread{
	//synchronized(任意非this对象x)解决脏读问题
	private Object2_16_2 obj;
	
	public Thread2_16_2B(Object2_16_2 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		Service2_16_2 ser=new Service2_16_2();
		ser.addMethod(obj, "BBB");
	}	

}
