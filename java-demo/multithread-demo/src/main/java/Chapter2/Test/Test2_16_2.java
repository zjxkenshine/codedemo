package Chapter2.Test;

import Chapter2.Object.Object2_16_2;
import Chapter2.Thread.Thread2_16_2A;
import Chapter2.Thread.Thread2_16_2B;

public class Test2_16_2 {
	//synchronized(�����this����x)����������
	
	/**1.�����߳�ִ�з�����˳��ȷ�������Ե�A��B�����߳�ִ�д��з�֧�жϵķ���ʱ��
	 * 	   ������߼��ϵĴ��󣬻�������
	 * 
	 * 2.���������ͬ����
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Object2_16_2 obj=new Object2_16_2();
		Thread2_16_2A thread1=new Thread2_16_2A(obj);
		thread1.start();
		Thread2_16_2B thread2=new Thread2_16_2B(obj);
		thread2.start();
		Thread.sleep(3000);
		System.out.println("listSize="+obj.getSize());     //size>2��������
	}

}
