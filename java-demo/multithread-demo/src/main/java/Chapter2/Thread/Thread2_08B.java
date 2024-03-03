package Chapter2.Thread;

import Chapter2.Object.Object2_08S;

public class Thread2_08B extends Thread{
	//同步不具有继承性
private Object2_08S obj=new Object2_08S();
	
	public Thread2_08B(Object2_08S obj){
		super();
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		obj.MethodA();
	}

}
