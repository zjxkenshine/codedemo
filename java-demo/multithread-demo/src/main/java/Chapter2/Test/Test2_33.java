package Chapter2.Test;

import Chapter2.Thread.Thread2_33;

public class Test2_33 {
	//ʹ��ԭ�����i++���в���
	
	/**1.����i++ʱʹ��synchronized�ؼ���ʵ��ͬ���⣬��������AtomicIntegerԭ�������ʵ��
	 * 
	 * 2.ԭ�Ӳ����ǲ��ɷָ������û�������߳����жϻ�������ԭ�Ӳ����еı�����
	 * 	 һ��ԭ�����;���һ��ԭ�Ӳ����Ŀ������ͣ���������û����������������̰߳�ȫ
	 * 
	 */
	
	public static void main(String[] args) {
		Thread2_33 thread=new Thread2_33();
		Thread t1=new Thread(thread);
		t1.start();
		Thread t2=new Thread(thread);
		t2.start();
		Thread t3=new Thread(thread);
		t3.start();
		Thread t4=new Thread(thread);
		t4.start();
	}
	
}
