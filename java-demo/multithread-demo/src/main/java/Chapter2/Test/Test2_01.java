package Chapter2.Test;

import Chapter2.Object.Object2_01;
import Chapter2.Thread.Thread2_01A;
import Chapter2.Thread.Thread2_01B;

public class Test2_01 {
	//�����ڵı���Ϊ�̰߳�ȫ
	/**1.���̰߳�ȫ���ڶ���̶߳� ͬһ�� �����е�ʵ���������в�������ʱ����
	 * 	   �����ĺ���������
	 * 
	 * 2.���̰߳�ȫ������ʵ�������У������ڲ���˽�б������򲻴��ڷ��̰߳�ȫ
	 * 
	 * 3.�����ڲ���Զ�̰߳�ȫ
	 */
	public static void main(String[] args) {
		Object2_01 obj=new Object2_01();
		Thread2_01A thread1=new Thread2_01A(obj);
		thread1.start();
		Thread2_01B thread2=new Thread2_01B(obj);
		thread2.start(); 
	}

}
