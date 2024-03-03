package Chapter2.Thread;

import Chapter2.Object.Object2_20_1;

public class Thread2_20_1B extends Thread{
	//静态同步synchronized方法1
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Object2_20_1.printB();
	}

}
