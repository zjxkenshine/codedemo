package Chapter3.Thread;

import Chapter3.Object.Object3_27_2;

public class Thread3_27 extends Thread{
	//验证多个线程的初始值
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<10;i++){
				System.out.println("在Thread线程中得到的值="+Object3_27_2.t.get());
				Thread.sleep(100);
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
