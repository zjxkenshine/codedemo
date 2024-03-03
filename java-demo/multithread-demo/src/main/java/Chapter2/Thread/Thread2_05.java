package Chapter2.Thread;

import Chapter2.Object.Object2_05;

public class Thread2_05 extends Thread{
	// ‘‡∂¡£®dirtyRead£©
	
	private Object2_05 obj;
	
	public Thread2_05(Object2_05 obj) {
		super();
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.setValue("B", "BBB");
	}

}
