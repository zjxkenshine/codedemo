package Chapter2.Object;

public class Object2_18 {
	//synchronized(�����this����x)������֤2��       �������߳�ִ��x�����е�synchronizedͬ������ʱ��ͬ��Ч��
	
	synchronized public void MethodA(){
		System.out.println("object���󷽷�MethodA �õ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
		System.out.println("------------------------------------------------");
		System.out.println("object���󷽷�MethodA �ͷ��� ʱ�䣺"+System.currentTimeMillis()+"�����߳�="+Thread.currentThread().getName());
	}

}
