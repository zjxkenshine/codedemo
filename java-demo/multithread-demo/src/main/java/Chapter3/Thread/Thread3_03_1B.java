package Chapter3.Thread;

import Chapter3.Object.Object3_03_1;

public class Thread3_03_1B extends Thread{
	//����wait()���ͷ�
	

	private Object lock;
	
	public Thread3_03_1B(Object lock){
		super();
		this.lock=lock;
	}
	
	public void run(){
		Object3_03_1 obj=new Object3_03_1();
		obj.method1(lock);
	}


}
