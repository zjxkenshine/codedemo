package Chapter2.Thread;

import Chapter2.Object.Object2_11;
import Chapter2.Object.Util1;

public class Thread2_11A extends Thread{
	//synchronized(this)解决同步方法的弊端
	
	private Object2_11 obj;
	public Thread2_11A(Object2_11 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Util1.beginTime1=System.currentTimeMillis();
		obj.dolongtask();
		Util1.endTime1=System.currentTimeMillis();
	}
}
