package Chapter2.Thread;

import Chapter2.Object.Object2_18;
import Chapter2.Object.Service2_18;

public class Thread2_18A extends Thread{
	//synchronized(任意非this对象x)结论验证2：       当其他线程执行x对象中的synchronized同步方法时呈同步效果
	
	private Object2_18 obj;
	private Service2_18 serv;
	
	public Thread2_18A(Service2_18 serv,Object2_18 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		this.serv=serv;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			serv.MethodB(obj);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
