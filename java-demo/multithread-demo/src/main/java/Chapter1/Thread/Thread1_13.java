package Chapter1.Thread;

public class Thread1_13 extends Thread{
	//sleep()方法，使this.currentThread()(正在执行的线程)休眠指定毫秒
	
	public void run(){
		try {
			System.out.println("this.curretThread().getName()="+this.currentThread().getName()+"begin="+System.currentTimeMillis());
			Thread.sleep(2000);                            //休眠两秒
			System.out.println("this.curretThread().getName()="+this.currentThread().getName()+"end="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
