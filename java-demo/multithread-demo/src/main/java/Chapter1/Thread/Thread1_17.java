package Chapter1.Thread;

public class Thread1_17 extends Thread {
	//this.isInterrupted():�Ǿ�̬�����������̶߳��󣨷ǵ�ǰ�̣߳��Ƿ��жϣ���������ж�״̬���
	public void run(){
		super.run();
		for(int i=0;i<200;i++){
			System.out.println("i="+(i+1));
		}
	}

}
