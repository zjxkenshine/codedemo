package Chapter1.Test;

import Chapter1.Thread.Thread1_21;

public class Test1_21 {
	//interrupt()��return���ʹ��ʵ��ֹͣ�̣߳�����ʹ�ã�
	
	public static void main(String[] args) throws InterruptedException {
		Thread1_21 thread=new Thread1_21();
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}
}
