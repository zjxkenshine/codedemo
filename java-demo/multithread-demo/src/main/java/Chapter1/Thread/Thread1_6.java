package Chapter1.Thread;

public class Thread1_6 extends Thread{
	//���ݹ������̰߳�ȫ�������߳�ͬʱ�����ݴ���
	private int count=6;
	
	//forѭ��ͬ����������Forѭ��
	public void run(){
		super.run();
		count--;
		System.out.println("���߳�"+this.currentThread().getName()+"���㣬count="+count);
	}
}
