package Chapter7.Test;

import Chapter7.Object.ObjectUncaughtExceptionHandler;
import Chapter7.Object.StateUncaughtExceptionHandler;
import Chapter7.Thread.Thread7_18;
import Chapter7.Thread.ThreadGroup7_18;

public class Test7_18_2 {
	
	/**
	 * �ж���ִֻ�ж���
	 * �޶���ִ�о�̬���Լ��߳�����쳣
	 * @param args
	 */
	
	public static void main(String[] args) {
		ThreadGroup7_18 tg=new ThreadGroup7_18("wod�߳���");
		
		Thread7_18 th=new Thread7_18(tg,"�߳�1");
		
		//����
		//th.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());  //ע�͵���һ��
		
		//��
		Thread7_18.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		th.start();
		
	}

}
