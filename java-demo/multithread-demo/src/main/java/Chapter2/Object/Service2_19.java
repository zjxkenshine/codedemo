package Chapter2.Object;

public class Service2_19 {
	//synchronized(�����this����x)������֤3��       �������߳�ִ��x�����е�synchronized(this)ͬ�������ʱ��ͬ��Ч��
	
	public void MethodB(Object2_19 obj) throws InterruptedException{
		synchronized (obj) {
			System.out.println("service���󷽷�MethodB �õ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
			Thread.sleep(3000);
			System.out.println("service���󷽷�MethodB �ͷ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
		}
	}
}
