package Chapter2.Test;

import Chapter2.Thread.Thread2_32_1;

public class Test2_32_1 {
	//volatile�ķ�ԭ������
	
	/**
	 * ���н������10000�����ַ��̰߳�ȫ
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread2_32_1[] a=new Thread2_32_1[100];
		for(int i=0;i<100;i++){
			a[i]=new Thread2_32_1();
		}
		
		for(int i=0;i<100;i++){
			a[i].start();
		}
	}
}
