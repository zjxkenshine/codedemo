package Chapter2.Test;

import Chapter2.Object.Object2_18;
import Chapter2.Object.Service2_18;
import Chapter2.Thread.Thread2_18A;
import Chapter2.Thread.Thread2_18B;

public class Test2_18 {
	//synchronized(�����this����x)������֤2��       �������߳�ִ��x�����е�synchronizedͬ������ʱ��ͬ��Ч��
	
	public static void main(String[] args) throws InterruptedException {
		Service2_18 serv=new Service2_18();
		Object2_18 obj=new Object2_18();
		Thread2_18A a=new Thread2_18A(serv, obj);
		a.setName("AAAA");
		a.start();
		Thread.sleep(100);
		Thread2_18B b=new Thread2_18B(obj);
		b.setName("BBBB");
		b.start();
		
	}

}
