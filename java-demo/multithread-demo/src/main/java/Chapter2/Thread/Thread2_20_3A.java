package Chapter2.Thread;

import Chapter2.Object.Object2_20_3;

public class Thread2_20_3A extends Thread{
	//静态同步synchronized方法3
	
	private Object2_20_3 obj;
	
	public Thread2_20_3A(Object2_20_3 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.printA();
	}

}
