package Chapter2.Test;

import Chapter2.Object.Service2_22_2;
import Chapter2.Thread.Thread2_22_2A;
import Chapter2.Thread.Thread2_22_2B;

public class Test2_22_2 {
	//��String�����ص����ԡ���synchronized(String)����������
	/**
	 * �ڴ��������£�ͬ��synchronized����鶼����String��Ϊ���Ķ��󣬶�����������
	 * ����new Object()ʵ����һ��Object���󣬵����������뻺����
	 * 
	 */
	
	
	//�������ͬ������
	public static void main(String[] args) {
		Service2_22_2 ser=new Service2_22_2();
		Thread2_22_2A a=new Thread2_22_2A(ser);
		a.setName("A");
		a.start();
		Thread2_22_2B b=new Thread2_22_2B(ser);
		b.setName("B");
		b.start();
	}

}
