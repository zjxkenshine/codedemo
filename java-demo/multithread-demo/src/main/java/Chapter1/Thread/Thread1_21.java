package Chapter1.Thread;

public class Thread1_21 extends Thread{
	//interrupt()��return���ʹ��ʵ��ֹͣ�̣߳�����ʹ�ã�
	
	public void run(){
		while(true){
			if(this.isInterrupted()){
				System.out.println("�߳�ֹͣ��");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}
