package Chapter4.Test;

import Chapter4.Object.Service4_13_1;

public class Test4_13_1 {
	//lockInterruptibly()����
	
	/**����void lockInterruptibly()�������ǣ������ǰ�߳�δ���жϣ����ȡ����������Ѿ����ж����쳣
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_13_1 ser=new Service4_13_1();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ser.TestMethod();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1=new Thread(run);
		t1.setName("AAA");
		t1.start();
		Thread.sleep(500);
		Thread t2=new Thread(run);
		t2.setName("BBB");
		t2.start();
		t2.interrupt();   //b�߳��ж�ʱ�ᱨ��
		System.out.println("main end");
	}

}
