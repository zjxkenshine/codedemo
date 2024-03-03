package Chapter3.Thread;


import Chapter3.Object.Object3_28_2;

public class Thread3_28 extends Thread{
	//InheritableThreadLocal值继承
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			for(int i=0;i<10;i++){
				System.out.println("子线程得到的值："+Object3_28_2.t.get());
				Thread.sleep(100);
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
