package Chapter4.Test;

import Chapter4.Object.Service4_05;
import Chapter4.Thread.Thread4_05A;
import Chapter4.Thread.Thread4_05B;

public class Test4_05 {
	//ʹ�ö��Conditionʵ��֪ͨ�����߳�ʱ�Ĵ����÷�
	
	/**
	 * �����̶߳��������ˣ���������ָ���̣߳������ȶ��߳̽��з��飬
	 * Ȼ���ٻ���ָ�����е��߳�,����4_06
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_05 ser=new Service4_05();
		Thread4_05A a=new Thread4_05A(ser);
		a.setName("A");
		a.start();
		Thread4_05B b=new Thread4_05B(ser);
		b.setName("B");
		b.start();
		Thread.sleep(3000);
		ser.signalAll();
	}

}
