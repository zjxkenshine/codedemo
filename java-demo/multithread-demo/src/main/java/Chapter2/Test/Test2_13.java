package Chapter2.Test;

import Chapter2.Object.Object2_13;
import Chapter2.Thread.Thread2_13A;
import Chapter2.Thread.Thread2_13B;
import Chapter2.Thread.Thread2_13C;

public class Test2_13 {
	//synchronized�������ͬ����
	
	/**��һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
	 * �����̶߳�ͬһ��object����������synchronized(this)ͬ������齫������
	 * ˵��synchronizedʹ�õġ��������������ͬһ��
	 * 
	 * synchronized(this)����飨����A,B��ͬ��������synchronized����������C��
	 */
	
	public static void main(String[] args) {
		Object2_13 obj=new Object2_13();
		Thread2_13A a=new Thread2_13A(obj);
		a.start();
		Thread2_13B b=new Thread2_13B(obj);
		b.start();
		Thread2_13C c=new Thread2_13C(obj);
		c.start();
	}

}
