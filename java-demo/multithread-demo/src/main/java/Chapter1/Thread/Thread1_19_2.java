package Chapter1.Thread;

public class Thread1_19_2 extends Thread{
	//在interrput()状态下使用sleep()的情况
	//抛出异常从而停止线程（推荐使用）
	
	public void run(){
		super.run();
		try{
			for(int i=0;i<1000;i++){
				System.out.println("i="+(i+1));
			}
			System.out.println("run begin");
			Thread.sleep(1000);
			System.out.println("run end");
		}catch(InterruptedException e){
			System.out.println("先停止，再遇见sleep!出错进入catch");
			e.printStackTrace();
		}
	}
	
}
