package Chapter7.Thread;

public class Thread7_01 extends Thread{
	//��֤NEW,RUNNABLE��TERMINATED״̬
	
	public Thread7_01() {
		// TODO Auto-generated constructor stub
		System.out.println("���췽���е�״̬��"+Thread.currentThread().getState());          //������ʾ����main�̵߳�״̬
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("run�����е�״̬��"+Thread.currentThread().getState());
	}

}
