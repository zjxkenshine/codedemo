package Chapter4.Test;

import Chapter4.Object.Service4_01;
import Chapter4.Thread.Thread4_01;

public class Test4_01 {
	//ʹ��ReentrantLockʵ��ͬ��������1
	
	/**1.ReentrantLock�ࣺ
	 *   ��java���߳���synchronized�ؼ�����ʵ���߳�֮���ͬ�����⣬
	 *   JDK1.5����ReentrantLock��Ҳ�ܴﵽͬ����Ч������������չ�����ϸ���ǿ��;
	 *   �磺������̽���ģ���·��֧֪ͨ�ȹ��ܣ�������ʹ����Ҳ��synchronized�������
	 * 
	 * 
	 * 2.���ӿ��Կ��������ӡ�ģ���Ϊ��ǰ�߳��Ѿ��������������߳�֮��Ĵ�ӡ˳���������
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Service4_01 ser=new Service4_01();
		Thread4_01 t1=new Thread4_01(ser);
		Thread4_01 t2=new Thread4_01(ser);
		Thread4_01 t3=new Thread4_01(ser);
		Thread4_01 t4=new Thread4_01(ser);
		Thread4_01 t5=new Thread4_01(ser);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
