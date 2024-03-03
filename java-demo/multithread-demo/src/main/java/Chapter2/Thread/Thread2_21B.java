package Chapter2.Thread;

import Chapter2.Object.Object2_21;

public class Thread2_21B extends Thread{
	//synchronized(class)´úÂë¿é
	
	private Object2_21 obj;
	
	public Thread2_21B(Object2_21 obj){
		super();
	    this.obj=obj;
	}
	
	public void run(){
		obj.printB();
	}

	

}