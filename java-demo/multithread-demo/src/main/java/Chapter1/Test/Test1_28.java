package Chapter1.Test;

import Chapter1.Thread.Thread1_28_1;
import Chapter1.Thread.Thread1_28_2;

public class Test1_28 {
	//�߳����ȼ��������
	//���ȼ��ϸߵ��̲߳�һ��ÿ�ζ���ִ����
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			Thread1_28_1 thread1=new Thread1_28_1();
			thread1.setPriority(5);
			thread1.start();
			Thread1_28_2 thread2=new Thread1_28_2();
			thread2.setPriority(6);
			thread2.start();
		}
	}
}
