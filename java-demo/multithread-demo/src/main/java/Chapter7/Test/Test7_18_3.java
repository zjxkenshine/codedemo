package Chapter7.Test;

import Chapter7.Thread.Thread7_18;
import Chapter7.Thread.ThreadGroup7_18;

public class Test7_18_3 {
	//�߳��쳣����Ĵ���
	
	/**
	 * ��Ҫ��ӡ����̬�������Ϣ������ uncaughtException(Thread t, Throwable e)�м���uncautException(t,e)
	 */
	public static void main(String[] args) {
		ThreadGroup7_18 tg=new ThreadGroup7_18("wod�߳���");
		
		Thread7_18 th=new Thread7_18(tg,"�߳�1");
		th.start();
	}
	

}
