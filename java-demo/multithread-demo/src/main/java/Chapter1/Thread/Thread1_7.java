package Chapter1.Thread;

public class Thread1_7 extends Thread{
	//��ȫ���ݹ����̰߳�ȫ
	private int count=6;
	
	//forѭ��ͬ����������Forѭ��
	synchronized public void run(){     //synchronizedʵ���̰߳�ȫ
		super.run();
		count--;
		System.out.println("���߳�"+this.currentThread().getName()+"���㣬count="+count);
	}
}
