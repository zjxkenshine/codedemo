package Chapter2.Test;

import Chapter2.Thread.Thread2_20_2A;
import Chapter2.Thread.Thread2_20_2B;
import Chapter2.Thread.Thread2_20_2C;

public class Test2_20_2 {
	//��̬ͬ��synchronized����2
	
	/**synchronized�ӵ�static��̬�������Ǹ�class���������ӵ���static�����������Ƕ���
	 * 
	 * ����A�뷽��C�첽���ã�һ�����ж�������һ������Class��
	 */
	
	public static void main(String[] args) {
		Thread2_20_2A a=new Thread2_20_2A();
		a.setName("AAA");
		a.start();
		Thread2_20_2B b=new Thread2_20_2B();
		b.setName("BBB");
		b.start();
		Thread2_20_2C c=new Thread2_20_2C();
		c.setName("CCC");
		c.start();
	}

}
