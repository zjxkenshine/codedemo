package Chapter2.Thread;

import Chapter2.Object.Object2_09;
import Chapter2.Object.Util1;

public class Thread2_09B extends Thread{
	//synchronized方法的弊端--长时间排队
	
	private Object2_09 obj;
	public Thread2_09B(Object2_09 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Util1.beginTime2=System.currentTimeMillis();
		obj.dolongtask();
		Util1.endTime2=System.currentTimeMillis();
	}
}
