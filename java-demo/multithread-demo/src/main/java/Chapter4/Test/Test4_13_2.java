package Chapter4.Test;

import Chapter4.Object.Service4_13_2;

public class Test4_13_2 {
	//tryLock()����
	
	/**
	 * ����boolean tryLock()�������ǡ����ڵ���ʱ����δ����һ���̳߳���ʱ�Ż�ȡ����
	 * ��δ��ռ��ͬ��������ͬ���������������
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_13_2 ser=new Service4_13_2();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.Method();
			}
		};
		
		Thread t1=new Thread(run);
		t1.setName("AAAA");
		t1.start();
		Thread.sleep(2000);
		Thread t2=new Thread(run);
		t2.setName("BBBB");
		t2.start();
		
		
	}
	
	

}
