package Chapter2.Test;

import Chapter2.Object.Object2_02;
import Chapter2.Thread.Thread2_02A;
import Chapter2.Thread.Thread2_02B;

public class Test2_03 {
	//����������������
	
	/**1.������Test2_02,�������������������첽(asychronized)ִ��
	 * 
	 * 2.ͬ��(sychronized)ִ��ǰ���Ƕ���̷߳��ʡ�ͬһ��������
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_02 obj1=new Object2_02();        //��ͬ�Ķ���
		Object2_02 obj2=new Object2_02();
		Thread2_02A thread1=new Thread2_02A(obj1);
		thread1.start();
		Thread2_02B thread2=new Thread2_02B(obj2);
		thread2.start(); 
	}
	
}
