package Chapter2.Test;

import Chapter2.Object.Object2_04_2;
import Chapter2.Thread.Thread2_04_2A;
import Chapter2.Thread.Thread2_04_2B;

public class Test2_04_2 {
	//synchronized�������������������Ƿ���
	
	/**1.A�߳��ȳ���object�����lock����B�߳̿������첽��ʽ����object�����еķ�synchronized���ͷ���
	 * 
	 * 2.A�߳��ȳ���object�����lock����B�߳��������ʱ����object������synchronized���ͷ���
	 * 	 ����Ҫ�ȴ���Ҳ����ͬ����
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_04_2 obj=new Object2_04_2();
		Thread2_04_2A a=new Thread2_04_2A(obj);
		a.setName("a");
		Thread2_04_2B b=new Thread2_04_2B(obj);
		b.setName("b");
		a.start();
		b.start();
	}
	
}
