package Chapter2.Test;

import Chapter2.Object.Object2_15_1;
import Chapter2.Thread.Thread2_15_1A;
import Chapter2.Thread.Thread2_15_1B;

public class Test2_15_1 {
	//�������this������Ϊ�������������
	
	/**1.����̵߳���ͬһ�������еĲ�ͬ���Ƶ�synchronizedͬ��������synchronized(this)ͬ�������ʱ
	 * 	 ����Ч���ǰ�˳����У�Ҳ����ͬ���ģ�������
	 * 
	 * 2.java��֧�ֶ�"�������"��Ϊ"���������"��ʵ��ͬ���Ĺ��ܣ������ʵ�������򷽷��Ĳ���
	 * 	 ʹ�ø�ʽΪsynchronized(��this����x)
	 * 
	 * 3.synchronized(��this����x)ͬ�����������ã�
	 * 	 ��ͬһ��������synchronized(��this����x)ͬ�����������
	 *  ͬһʱ��ֻ��һ���߳���ִ��ͬһ�����synchronized(��this����x)ͬ������
	 *  
	 * 4.synchronized(��this����x)ͬ��������ŵ㣺
	 *   ��ͬһ�����е�ͬ��������synchronized(this)�����첽����������thisͬ�������������
	 *   ���Ĳ��Ƕ���
	 */
	
	public static void main(String[] args) {
		
		Object2_15_1 obj=new Object2_15_1();
		Thread2_15_1A thread1=new Thread2_15_1A(obj);
		thread1.setName("a");
		thread1.start();
		Thread2_15_1B thread2=new Thread2_15_1B(obj);
		thread2.setName("b");
		thread2.start();
		
	}

}
