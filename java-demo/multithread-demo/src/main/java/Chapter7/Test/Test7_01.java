package Chapter7.Test;

import Chapter7.Thread.Thread7_01;

public class Test7_01 {
	//��֤NEW,RUNNABLE��TERMINATED״̬
	
	/**
	 * NEW״̬��ʵ������δִ��run��״̬��RUNNABLE���߳̽�������ʱ��״̬��
	 * TERMINATED״̬���߳�����ʱ��״̬
	 * 
	 * ʹ��getState()���Բ鿴״̬
	 */
	
	public static void main(String[] args) {
		try{
			Thread7_01 t1=new Thread7_01();
			System.out.println("main�����е�״̬1��"+t1.getState());
			Thread.sleep(1000);
			t1.start();
			Thread.sleep(1000);
			System.out.println("main�����е�״̬2��"+t1.getState());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
