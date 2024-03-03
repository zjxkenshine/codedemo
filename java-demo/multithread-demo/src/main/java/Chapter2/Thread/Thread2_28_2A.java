package Chapter2.Thread;

import Chapter2.Object.Object2_28_2;
import Chapter2.Object.Userinfo2_28_2;

public class Thread2_28_2A extends Thread{
	//锁对象的改变
	
	private Object2_28_2 obj;
	private Userinfo2_28_2 info;
	
	public Thread2_28_2A(Object2_28_2 obj,Userinfo2_28_2 info){
		this.info=info;
		this.obj=obj;
	}
	
	public void run(){
		obj.methodA(info);
	}

}
