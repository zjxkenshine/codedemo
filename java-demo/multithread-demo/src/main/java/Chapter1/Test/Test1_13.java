package Chapter1.Test;

import Chapter1.Thread.Thread1_13;

public class Test1_13 {
//sleep()������ʹthis.currentThread()(����ִ�е��߳�)����ָ������
	public static void main(String[] args) {
		Thread1_13 thread=new Thread1_13();
		System.out.println("begin="+System.currentTimeMillis());
	//	thread.run();              //ͬ��
		thread.start();             //�첽
		System.out.println("end="+System.currentTimeMillis());
	}
}
