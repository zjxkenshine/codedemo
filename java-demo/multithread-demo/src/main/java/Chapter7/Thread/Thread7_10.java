package Chapter7.Thread;

public class Thread7_10 extends Thread{
	//�߳����ڵ��߳�����ֹͣ
	
	public Thread7_10(ThreadGroup tg,String name) {
		// TODO Auto-generated constructor stub
		super(tg,name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("ThreadName"+Thread.currentThread().getName()+" ��ʼ��ѭ��");
		while(!this.isInterrupted()){
		}
		System.out.println("ThreadName"+Thread.currentThread().getName()+" ��ѭ��������");
	}

}
