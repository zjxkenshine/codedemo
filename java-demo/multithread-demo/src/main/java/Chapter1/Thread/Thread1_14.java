package Chapter1.Thread;

public class Thread1_14 extends Thread{
	//getId()��������ȡ�̵߳�Ψһ��ʾ
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getId());
	}
}
