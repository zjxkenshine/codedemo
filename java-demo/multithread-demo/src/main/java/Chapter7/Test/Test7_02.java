package Chapter7.Test;

import Chapter7.Thread.Thread7_02;

public class Test7_02 {
	//��֤TIMED_WAITING״̬
	
	/**
	 * �߳�״̬TIMED_WAITING�����߳�ִ����Thread.sleep()�������ʵȴ�״̬���ȴ�ʱ�䵽���������ִ��
	 * 
	 * ִ��sleep������״̬��ö��ֵ�ͱ�Ϊ��TIMED_WAITING
	 */
	
	public static void main(String[] args) {
		try{
			Thread7_02 t1=new Thread7_02();
			t1.start();
			Thread.sleep(1000);
			System.out.println("main�����е�״̬"+t1.getState());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
