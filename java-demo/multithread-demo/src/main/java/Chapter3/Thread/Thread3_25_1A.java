package Chapter3.Thread;

import Chapter3.Object.Object3_25_1;

public class Thread3_25_1A extends Thread{
	//验证线程变量的隔离性
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<100;i++){
				Object3_25_1.t1.set("ThreadA"+(i+1));
				System.out.println("ThreadA get value="+Object3_25_1.t1.get());
				Thread.sleep(200);
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
