package Chapter1.Thread;

public class Thread1_19_2 extends Thread{
	//��interrput()״̬��ʹ��sleep()�����
	//�׳��쳣�Ӷ�ֹͣ�̣߳��Ƽ�ʹ�ã�
	
	public void run(){
		super.run();
		try{
			for(int i=0;i<1000;i++){
				System.out.println("i="+(i+1));
			}
			System.out.println("run begin");
			Thread.sleep(1000);
			System.out.println("run end");
		}catch(InterruptedException e){
			System.out.println("��ֹͣ��������sleep!�������catch");
			e.printStackTrace();
		}
	}
	
}
