package Chapter1.Thread;

public class Thread1_9 extends Thread{
	//currentThread()���������ش�������ڱ��ĸ��̵߳���
	
	public Thread1_9(){
		System.out.println("���췽�����߳�"+Thread.currentThread().getName()+"ִ��");
	}
	
	public void run(){
		System.out.println("run�������߳�"+Thread.currentThread().getName()+"ִ��");
	}
	
	
}
