package Chapter3.Thread;

import Chapter3.Object.Object3_17;

public class Thread3_17A extends Thread{
	//实战：等待/通知交叉备份
	
	private Object3_17 obj;
	
	public Thread3_17A(Object3_17 obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.backup1();
	}

}
