package Chapter4.Test;

import Chapter4.Object.Service4_13_3;

public class Test4_13_3 {
	//tryLock(long timeout,TimeUnit unit)
	
	/**����tryLock(long timeout,TimeUnit unit)�����ǣ�������ڸ�����ʱ����û�б���һ���̱߳��֣�
	 * �ҵ�ǰ�߳�δ�жϣ����ø���
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_13_3 ser=new Service4_13_3();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.testMethod();
			}
		};
		
		Thread t1=new Thread(run);
		t1.setName("AAAA");
		t1.start();
		Thread t2=new Thread(run);
		t2.setName("BBBB");
		t2.start();
		t2.interrupt();
		
	}

}
