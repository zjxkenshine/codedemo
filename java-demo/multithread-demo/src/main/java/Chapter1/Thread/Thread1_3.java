package Chapter1.Thread;

public class Thread1_3 extends Thread{
	//�̲߳�ȷ���ԣ�Start����˳�����߳�ִ��˳��
	private int i;
	public Thread1_3(int i){
		super();
		this.i=i;
	}
	
	public void run(){
		System.out.println("ִ���߳�"+i);
	}

}
