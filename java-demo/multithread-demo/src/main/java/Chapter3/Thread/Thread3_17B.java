package Chapter3.Thread;

import Chapter3.Object.Object3_17;

public class Thread3_17B extends Thread{
	//ʵս���ȴ�/֪ͨ���汸��

	private Object3_17 obj;
	
	public Thread3_17B(Object3_17 obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.backup2();
	}

}
