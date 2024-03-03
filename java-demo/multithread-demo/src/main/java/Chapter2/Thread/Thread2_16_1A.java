package Chapter2.Thread;


import Chapter2.Object.Object2_16_1;

public class Thread2_16_1A extends Thread{
	//synchronized(任意非this对象x)解决脏读问题
	
	private Object2_16_1 obj;
	
	public Thread2_16_1A(Object2_16_1 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		for(int i=0;i<1000;i++){
			obj.add("ThreadA"+i);
		}
	}

}
