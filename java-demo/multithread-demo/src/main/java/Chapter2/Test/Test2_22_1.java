package Chapter2.Test;

import Chapter2.Object.Object2_22_1;
import Chapter2.Thread.Thread2_22_1A;
import Chapter2.Thread.Thread2_22_1B;

public class Test2_22_1 {
	// ��String�����ص����ԡ���synchronized(String)����������
	
	/**
	 * 1.JVM�о���String�����ػ���Ĺ��ܣ���synchronized(String)ͬ��������String����ʹ��ʱ��������������
	 * 
	 * 2.B��A�ļ���������AAA,b��Զ�ò�����
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_22_1 obj=new Object2_22_1();
		Thread2_22_1A a=new Thread2_22_1A(obj);
		a.setName("A");
		a.start();
		Thread2_22_1B b=new Thread2_22_1B(obj);
		b.setName("B");
		b.start();
	}

}
