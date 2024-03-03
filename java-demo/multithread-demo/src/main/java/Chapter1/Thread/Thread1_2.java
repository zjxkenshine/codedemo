package Chapter1.Thread;

public class Thread1_2 extends Thread{
	//线程的随机性
	
	public void run(){
		try{
			for(int i=0;i<10;i++){
				int time =(int)(Math.random()*1000);
				Thread.sleep(time);     //线程休眠
				System.out.println("正在执行线程"+Thread.currentThread().getName()); //获取当前线程名
			}
		}catch(InterruptedException e){   //中断异常
			e.printStackTrace();
		}
	}
	
}
