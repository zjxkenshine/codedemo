package Chapter2.Test;

import Chapter2.Object.Object2_19;
import Chapter2.Object.Service2_19;
import Chapter2.Thread.Thread2_19A;
import Chapter2.Thread.Thread2_19B;

public class Test2_19 {
	//synchronized(�����this����x)������֤3��       �������߳�ִ��x�����е�synchronized(this)ͬ�������ʱ��ͬ��Ч��
	//��������̵߳��ò���synchronized����ʱ�����첽ִ��
	
	public static void main(String[] args) throws InterruptedException {
		Service2_19 serv=new Service2_19();
		Object2_19 obj=new Object2_19();
		Thread2_19A a=new Thread2_19A(serv, obj);
		a.setName("AAAA");
		a.start();
		Thread.sleep(100);
		Thread2_19B b=new Thread2_19B(obj);
		b.setName("BBBB");
		b.start();
	}

}
