package Chapter1.Thread;

public class Thread1_13 extends Thread{
	//sleep()������ʹthis.currentThread()(����ִ�е��߳�)����ָ������
	
	public void run(){
		try {
			System.out.println("this.curretThread().getName()="+this.currentThread().getName()+"begin="+System.currentTimeMillis());
			Thread.sleep(2000);                            //��������
			System.out.println("this.curretThread().getName()="+this.currentThread().getName()+"end="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
