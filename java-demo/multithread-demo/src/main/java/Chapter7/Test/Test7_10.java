package Chapter7.Test;

import Chapter7.Thread.Thread7_10;

public class Test7_10 {
	//�߳����ڵ��߳�����ֹͣ
	
	/**
	 * �����߳���ThreadGroup��interrupt()����ʱ���Խ����߳��������������е��߳�����ֹͣ
	 */
	
	public static void main(String[] args) {
		try{
			ThreadGroup tg=new ThreadGroup("���߳���");
			for(int i=0;i<5;i++){
				Thread7_10 t1=new Thread7_10(tg, " �߳�"+(i+1));
				t1.start();
			}
			
			Thread.sleep(5000);
			tg.interrupt();
			System.out.println("������interrupt����");
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("ֹͣ��");
			e.printStackTrace();
		}
	}

}
