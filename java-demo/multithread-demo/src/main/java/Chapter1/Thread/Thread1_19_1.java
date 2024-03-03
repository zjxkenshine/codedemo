package Chapter1.Thread;

public class Thread1_19_1 extends Thread{
	//在sleep()状态下使用interrput()的情况
	//抛出异常从而停止线程（推荐使用）
	
	public void run(){
		super.run();
		try{
			System.out.println("run begin");
			Thread.sleep(20000);
			System.out.println("run end");
		}catch(InterruptedException e){
			System.out.println("在沉睡中被停止，进入catch!"+this.isInterrupted());   
			//停止后清除停止状态标记
			e.printStackTrace();
		}
		
	}

}
