package Chapter2.Test;

import Chapter2.Object.Object2_20_3;
import Chapter2.Thread.Thread2_20_3A;
import Chapter2.Thread.Thread2_20_3B;

public class Test2_20_3 {
	//��̬ͬ��synchronized����3
	
	/**
	 * CLASS��������Զ����ж���ʵ��������
	 */
	
	public static void main(String[] args) {
		
		Object2_20_3 obj1=new Object2_20_3();
		Object2_20_3 obj2=new Object2_20_3();      //��ͬ������Ȼͬ��ִ��
		Thread2_20_3A a=new Thread2_20_3A(obj1);
		a.setName("AAA");
		a.start();
		Thread2_20_3B b=new Thread2_20_3B(obj2);
		b.setName("BBB");
		b.start();
		
		
		
	}

}
