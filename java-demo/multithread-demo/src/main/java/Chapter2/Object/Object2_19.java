package Chapter2.Object;

public class Object2_19 {
	//synchronized(�����this����x)������֤3��       �������߳�ִ��x�����е�synchronized(this)ͬ�������ʱ��ͬ��Ч��
	
	public void MethodA(){
		synchronized (this) {
			System.out.println("object���󷽷�MethodA �õ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
			System.out.println("------------------------------------------------");
			System.out.println("object���󷽷�MethodA �ͷ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
		}
	}


}
