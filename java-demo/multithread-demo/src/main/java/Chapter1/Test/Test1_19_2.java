package Chapter1.Test;

import Chapter1.Thread.Thread1_19_2;

public class Test1_19_2{
	//��interrput()״̬��ʹ��sleep()�����
	//�׳��쳣�Ӷ�ֹͣ�̣߳��Ƽ�ʹ�ã�
	
	public static void main(String[] args) {
		Thread1_19_2 thread =new Thread1_19_2();
		thread.start();
		thread.interrupt();
		System.out.println("end!");
	}
	
	
}
