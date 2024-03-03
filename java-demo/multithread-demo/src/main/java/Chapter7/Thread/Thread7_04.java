package Chapter7.Thread;

import Chapter7.Object.Service7_04;

public class Thread7_04 extends Thread{
	//ÑéÖ¤WAITING×´Ì¬
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			synchronized (Service7_04.class) {
				Service7_04.class.wait();
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
