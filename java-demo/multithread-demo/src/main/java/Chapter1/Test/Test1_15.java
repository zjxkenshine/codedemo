package Chapter1.Test;

import Chapter1.Thread.Thread1_15;

public class Test1_15 {
	//�߳�ֹͣ��Thread.interrupt()ֹͣ��ǣ��޷�ֹͣ�߳�
	public static void main(String[] args) {
		try{
			Thread1_15 thread=new Thread1_15();
			thread.start();
			Thread.sleep(10);
			thread.interrupt();          //����ֹͣ��ǣ�����ֹͣ�߳�
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		
	}

}
