package Chapter7.Thread;

public class Thread7_05B extends Thread{
	//线程对象关联线程组：一级关联
	
	@Override
	public void run() {
		super.run();
		
		try{
			
			while(!Thread.currentThread().isInterrupted()){
				System.out.println("线程名称："+Thread.currentThread().getName());
			}
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
