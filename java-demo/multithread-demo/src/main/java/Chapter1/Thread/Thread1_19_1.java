package Chapter1.Thread;

public class Thread1_19_1 extends Thread{
	//��sleep()״̬��ʹ��interrput()�����
	//�׳��쳣�Ӷ�ֹͣ�̣߳��Ƽ�ʹ�ã�
	
	public void run(){
		super.run();
		try{
			System.out.println("run begin");
			Thread.sleep(20000);
			System.out.println("run end");
		}catch(InterruptedException e){
			System.out.println("�ڳ�˯�б�ֹͣ������catch!"+this.isInterrupted());   
			//ֹͣ�����ֹͣ״̬���
			e.printStackTrace();
		}
		
	}

}
