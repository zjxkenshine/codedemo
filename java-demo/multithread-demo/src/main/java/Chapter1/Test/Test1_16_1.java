package Chapter1.Test;

import Chapter1.Thread.Thread1_16;

public class Test1_16_1 {
	//this.interrupted():�жϵ�ǰ�߳��Ƿ��жϣ�ִ�к�����жϱ��
	//��ǰ���ָ�������и÷������̣߳���ǰ׺�޹�
	
	public static void main(String[] args) {
		try{
			Thread1_16 thread=new Thread1_16();
			thread.start();
			Thread.sleep(10);
			thread.interrupt();
			System.out.println(Thread.currentThread().getName()+"�Ƿ�ֹͣ��="+thread.interrupted());    //��main�̵߳���
			System.out.println(Thread.currentThread().getName()+"�Ƿ�ֹͣ��="+thread.interrupted());
			
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
	}

}
