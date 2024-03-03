package Chapter2.Thread;

import Chapter2.Object.Object2_10;

public class Thread2_10B extends Thread{
	//synchronized同步代码块的使用
	
	private Object2_10 obj;
	
	public Thread2_10B(Object2_10 obj) {
		super();
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.MethodA();
	}

}
