package Chapter2.Thread;

import Chapter2.Object.Object2_34;

public class Thread2_34 extends Thread{
	//原子类也并非完全安全
	
	private Object2_34 obj=new Object2_34();
	public Thread2_34(Object2_34 obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.addNum();
	}

}
