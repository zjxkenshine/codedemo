package Chapter4.Test;

import Chapter4.Object.Service4_02;
import Chapter4.Thread.Thread4_02A;
import Chapter4.Thread.Thread4_02AA;
import Chapter4.Thread.Thread4_02B;
import Chapter4.Thread.Thread4_02BB;

public class Test4_02 {
	//ʹ��ReentratLockʵ��ͬ��������2
	
	/**1.����lock.lock()������߳̾ͳ�����"���������"�������ֳ�ֻ�еȴ����ͷ����ٴ�����
	 *   Ч����ʹ��synchronized�ؼ���һ�����߳�֮�仹��˳��ִ�е�
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_02 ser=new Service4_02();
		Thread4_02A t1=new Thread4_02A(ser);
		t1.setName("Thread4_02A");
		t1.start();
		Thread4_02AA t2=new Thread4_02AA(ser);
		t2.setName("Thread4_02AA");
		t2.start();
		Thread.sleep(2000);
		Thread4_02B t3=new Thread4_02B(ser);
		t3.setName("Thread4_02B");
		t3.start();
		Thread4_02BB t4=new Thread4_02BB(ser);
		t4.setName("Thread4_02BB");
		t4.start();
	}

}
