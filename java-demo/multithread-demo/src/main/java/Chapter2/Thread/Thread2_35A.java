package Chapter2.Thread;

import Chapter2.Object.Object2_35;

public class Thread2_35A extends Thread{
	//synchronized代码块有volatile同步功能          
	private Object2_35 obj=new Object2_35();
	public Thread2_35A(Object2_35 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.runMethod();
	}

}
