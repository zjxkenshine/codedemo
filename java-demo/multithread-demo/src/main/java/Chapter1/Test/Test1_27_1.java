package Chapter1.Test;

import Chapter1.Thread.Thread1_27_1;
import Chapter1.Thread.Thread1_27_2;

public class Test1_27_1 {
	//�߳����ȼ��Ĺ�����
	/**1.�����ȼ������ȴ󲿷�ִ���꣬������������ȼ�ȫ����ִ����
	 * 2.���ȼ����ܴ�ʱ��˭��ִ������������˳���޹�
	 * 3.cpu�ᾡ����ִ����Դ�ø����ȼ��Ƚϸߵ��߳�
	 */
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			Thread1_27_1 thread1=new Thread1_27_1();
			thread1.setPriority(10);
			thread1.start();
			Thread1_27_2 thread2=new Thread1_27_2();
			thread2.setPriority(1);
			thread2.start();
		}
	}
}
