package Chapter2.Test;

import Chapter2.Object.Object2_10;
import Chapter2.Thread.Thread2_10A;
import Chapter2.Thread.Thread2_10B;

public class Test2_10 {
	//synchronized(this)ͬ��������ʹ��
	
	/**���������̷߳���ͬһ�����synchronized(this)ͬ�������ʱ��һ��ʱ��ֻ��һ���̱߳�ִ�У�
	 * ��һ���̱߳���ȴ���ǰ�߳�ִ���������������ִ�иô����
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_10 obj=new Object2_10();
		Thread2_10A a=new Thread2_10A(obj);
		a.setName("a");
		a.start();
		Thread2_10B b=new Thread2_10B(obj);
		b.setName("b");
		b.start();
	}

}
