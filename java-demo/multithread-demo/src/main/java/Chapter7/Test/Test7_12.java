package Chapter7.Test;

import Chapter7.Thread.Thread7_12;

public class Test7_12 {
	//ʹ�߳̾���������
	
	/**
	 * ��������£��߳������ж���߳�֮��ִ�������ʱ��������ġ�
	 * ����ͨ���������ķ�ʽʹ���ǵ����о���������
	 */
	
	public static void main(String[] args) {
		Object lock=new Object();
		Thread7_12 t1=new Thread7_12(lock, "A", 1);
		Thread7_12 t2=new Thread7_12(lock, "B", 2);
		Thread7_12 t3=new Thread7_12(lock, "C", 0);
		t1.start();
		t2.start();
		t3.start();
	}

}
