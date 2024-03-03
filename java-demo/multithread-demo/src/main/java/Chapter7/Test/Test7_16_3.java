package Chapter7.Test;

import java.lang.Thread.UncaughtExceptionHandler;

import Chapter7.Thread.Thread7_16;

public class Test7_16_3 {
	//�߳��г����쳣�Ĵ���
	
	/**
	 * ����setUncaughtExceptionHandler(UncaughtExceptionHandler)�Ǹ�ָ���̶߳��������쳣��������������ʹ��
	 * ����setDefaultExceptionHandler(UncaughtExceptionHandler)��������Ϊ��ָ���߳���������̶߳�������Ĭ�ϵ��̴߳�����
	 */
	
	public static void main(String[] args) {
		
		
		    UncaughtExceptionHandler eh= new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// �쳣������
				System.out.println("�̣߳�"+t.getName()+"   �����쳣��");
				e.printStackTrace();
			}
		    };
		    
		    
		    Thread7_16.setDefaultUncaughtExceptionHandler(eh);
		    
		    Thread7_16 t1=new Thread7_16();
		    t1.setName("�߳�t1");
		    t1.start();
		    Thread7_16 t2=new Thread7_16();
		    t2.setName("�߳�t2");
		    t2.start();
	
	}

}
