package Chapter1.Thread;

public class Thread1_16 extends Thread{
	//this.interrupted():�жϵ�ǰ�߳��Ƿ��жϣ�ִ�к�����жϱ��
	
	public void run(){
		super.run();
		for(int i=0;i<200;i++){
			System.out.println("i="+(i+1));
		}
	}

}
