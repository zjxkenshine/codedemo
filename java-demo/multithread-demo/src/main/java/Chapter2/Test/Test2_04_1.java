package Chapter2.Test;

import Chapter2.Object.Object2_04_1;
import Chapter2.Thread.Thread2_04_1A;
import Chapter2.Thread.Thread2_04_1B;

public class Test2_04_1 {
	//synchronized�������������������Ƿ���
	
	/**object����ֻ��һ�����������,ͬ��ʱ�Ŷӽ���
	 * 
	 * ֻ�С�������Դ���Ķ�д����Ҫͬ������������ǹ�����Դ��������û��ͬ���ı�Ҫ
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_04_1 obj=new Object2_04_1();
		Thread2_04_1A a=new Thread2_04_1A(obj);
		a.setName("A");
		Thread2_04_1B b=new Thread2_04_1B(obj);
		b.setName("B");
		a.start();
		b.start();
	}

}
