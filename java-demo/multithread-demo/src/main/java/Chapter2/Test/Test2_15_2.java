package Chapter2.Test;

import Chapter2.Object.Object2_15_2;
import Chapter2.Thread.Thread2_15_2A;
import Chapter2.Thread.Thread2_15_2B;
import Chapter2.Thread.Thread2_15_2C;

public class Test2_15_2 {
	//�������this������Ϊ�������������
	
	/**ʹ��synchronized(this)����ͬ��ʱ�����������������ͬһ�����󣬷������н��Ϊ�첽
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_15_2 obj=new Object2_15_2();
		Thread2_15_2A a=new Thread2_15_2A(obj);
		a.start();
		Thread2_15_2B b=new Thread2_15_2B(obj);
		b.start();
		Thread2_15_2C c=new Thread2_15_2C(obj);
		c.start();
	}

}
