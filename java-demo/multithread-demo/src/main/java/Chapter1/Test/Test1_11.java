package Chapter1.Test;

import Chapter1.Thread.Thread1_11;

public class Test1_11 {
	//isAlive()�������ж��߳��Ƿ��ڻ״̬(����������δ��ֹ)
	public static void main(String[] args) throws InterruptedException {
		Thread1_11 thread=new Thread1_11();
		System.out.println("begin =="+thread.isAlive());    //false
		thread.start();
	//	Thread.sleep(1000);					//����1��
		System.out.println("end =="+thread.isAlive());  //�������ߣ���ֵ��ȷ��
	}
}
