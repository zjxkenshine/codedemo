package Chapter7.Test;

import Chapter7.Thread.Thread7_03A;
import Chapter7.Thread.Thread7_03B;

public class Test7_03 {
	//��֤BLOCKED״̬
	
	/**
	 * BOCKED״̬������ĳһ���̵߳ȴ�����ʱ��
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Thread7_03A t1=new Thread7_03A();
		t1.setName("AAA");
		t1.start();
		Thread.sleep(100);
		Thread7_03B t2=new Thread7_03B();
		t2.setName("BBB");
		t2.start();
		Thread.sleep(100);        //ȥ����һ��״̬��ΪRunnable
		System.out.println("main�����е�t2��״̬��"+t2.getState());
		Thread.sleep(5000);
		System.out.println("main�����е�t1��״̬��"+t1.getState());
	}

}
