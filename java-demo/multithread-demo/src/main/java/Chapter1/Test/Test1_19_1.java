package Chapter1.Test;

import Chapter1.Thread.Thread1_19_1;

public class Test1_19_1 {
	//��sleep()״̬��ʹ��interrput()�����
	//�׳��쳣�Ӷ�ֹͣ�̣߳��Ƽ�ʹ�ã�
	
	public static void main(String[] args) {
		try{
			Thread1_19_1 thread=new Thread1_19_1();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
