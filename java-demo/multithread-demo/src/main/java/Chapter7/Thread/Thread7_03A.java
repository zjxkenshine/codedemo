package Chapter7.Thread;

import Chapter7.Object.Service7_03;

public class Thread7_03A extends Thread{
	//ÑéÖ¤BLOCKED×´Ì¬
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Service7_03.serviceMethod();
	}

}
