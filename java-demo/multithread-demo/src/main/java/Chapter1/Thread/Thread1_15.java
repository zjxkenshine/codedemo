package Chapter1.Thread;

public class Thread1_15 extends Thread{
	//�߳�ֹͣ��Thread.interrupt()ֹͣ��ǣ��޷�ֹͣ�߳�
	
	public void run(){
		super.run();
		for(int i=0;i<20;i++){
			System.out.println("i="+(i+1));
		}
	}
}
