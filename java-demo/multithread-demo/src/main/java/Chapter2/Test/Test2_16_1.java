package Chapter2.Test;

import Chapter2.Object.Object2_16_1;
import Chapter2.Thread.Thread2_16_1A;
import Chapter2.Thread.Thread2_16_1B;

public class Test2_16_1 {
	//synchronized(�����this����x)����������
	
	/**
	 * ����̵߳���ͬһ������������ģ�����
	 * 
	 * A�߳���B�̵߳�ִ�����첽�ģ��޹��ɵ�
	 */
	
	public static void main(String[] args) {
		Object2_16_1 obj=new Object2_16_1();
		Thread2_16_1A thread1=new Thread2_16_1A(obj);
		thread1.setName("AAA");
		thread1.start();
		Thread2_16_1B thread2=new Thread2_16_1B(obj);
		thread2.setName("BBB");
		thread2.start();
	}

}
