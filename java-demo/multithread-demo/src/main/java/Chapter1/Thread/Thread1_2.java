package Chapter1.Thread;

public class Thread1_2 extends Thread{
	//�̵߳������
	
	public void run(){
		try{
			for(int i=0;i<10;i++){
				int time =(int)(Math.random()*1000);
				Thread.sleep(time);     //�߳�����
				System.out.println("����ִ���߳�"+Thread.currentThread().getName()); //��ȡ��ǰ�߳���
			}
		}catch(InterruptedException e){   //�ж��쳣
			e.printStackTrace();
		}
	}
	
}
