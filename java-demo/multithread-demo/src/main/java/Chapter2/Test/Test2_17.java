package Chapter2.Test;

import Chapter2.Object.Object2_17;
import Chapter2.Object.Service2_17;
import Chapter2.Thread.Thread2_17A;
import Chapter2.Thread.Thread2_17B;

public class Test2_17 {
	//synchronized(�����this����x)������֤1��      ����߳�ͬʱִ��synchronized(x){}ͬ�������ʱ��ͬ��Ч��
	
	public static void main(String[] args) {
		Service2_17 ser=new Service2_17();
		Object2_17 obj1=new Object2_17();
	//	Object2_17 obj2=new Object2_17();        //����ͬһ�����������
		
		Thread2_17A a=new Thread2_17A(ser, obj1);      
	//	Thread2_17A a=new Thread2_17A(ser, obj2);      //����ͬһ�����������,�첽
		a.setName("aaa");
		a.start();
		Thread2_17B b=new Thread2_17B(ser, obj1);
		b.setName("bbb");
		b.start();
	}

}
