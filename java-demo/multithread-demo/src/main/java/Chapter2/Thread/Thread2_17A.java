package Chapter2.Thread;

import Chapter2.Object.Object2_17;
import Chapter2.Object.Service2_17;

public class Thread2_17A extends Thread{
	//synchronized(任意非this对象x)结论验证1：      多个线程同时执行synchronized(x){}同步代码块时呈同步效果
	
	private Object2_17 obj;
	private Service2_17 serv;
	
	public Thread2_17A(Service2_17 serv,Object2_17 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		this.serv=serv;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		serv.MethodA(obj);
	}

}
