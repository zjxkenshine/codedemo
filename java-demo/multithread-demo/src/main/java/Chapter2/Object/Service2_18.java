package Chapter2.Object;

public class Service2_18 {
	//synchronized(�����this����x)������֤2��       �������߳�ִ��x�����е�synchronizedͬ������ʱ��ͬ��Ч��
	
	public void MethodB(Object2_18 obj) throws InterruptedException{
		synchronized (obj) {
			System.out.println("service���󷽷�MethodB �õ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
			Thread.sleep(3000);
			System.out.println("service���󷽷�MethodB �ͷ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
		}
	}

}
