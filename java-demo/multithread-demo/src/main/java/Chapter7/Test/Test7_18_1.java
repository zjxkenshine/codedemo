package Chapter7.Test;

import Chapter7.Object.ObjectUncaughtExceptionHandler;
import Chapter7.Object.StateUncaughtExceptionHandler;
import Chapter7.Thread.Thread7_18;

public class Test7_18_1 {
	//�߳��쳣����Ĵ���
	
	/**
	 * ���������һ�����Ĭ�ϵĴ�������ʱִֻ�ж���� 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread7_18 th=new Thread7_18();
		
		//����
		th.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());  //ע�͵���һ��
		
		//��
		Thread7_18.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		th.start();
		
	}

}
