package Chapter7.Test;

import java.lang.Thread.UncaughtExceptionHandler;

import Chapter7.Thread.Thread7_16;

public class Test7_16_2 {
	//�߳��г����쳣�Ĵ���
	
	/**
	 * ����setUncaughtExceptionHandler(UncaughtExceptionHandler)�������Ƕԡ�ָ�����̶߳�������Ĭ�ϵ��쳣������
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread7_16 t1=new Thread7_16();
		t1.setName("�߳�1");
		
		
		
		UncaughtExceptionHandler eh=new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("�̣߳�"+t.getName()+"   �����쳣��");
				e.printStackTrace();
			}
		};
		t1.setUncaughtExceptionHandler(eh);
		
		
		t1.start();
		Thread7_16 t2=new Thread7_16();
		t2.start();
		t2.start();
		
		
		
	}

}
