package Chapter3.Thread;

import Chapter3.Object.Object3_25_1;

public class Thread3_25_1B extends Thread{
	//��֤�̱߳����ĸ�����
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<100;i++){
				Object3_25_1.t1.set("ThreadB"+(i+1));
				System.out.println("ThreadB get value="+Object3_25_1.t1.get());
				Thread.sleep(200);
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
