package Chapter4.Test;

import Chapter4.Object.Service4_17;
import Chapter4.Thread.Thread4_17A;
import Chapter4.Thread.Thread4_17B;

public class Test4_17 {
	//ReentrantReadWriteLock���ʹ�ã�����������
	
	/**1.��ReentranLock������ȫ����������Ч����ͬһʱ��ֻ����һ���߳�ִ��ReentrantLock.lock����ĳ���
	 *   ������Ȼ���Ա�֤ʵ�������İ�ȫ�ԣ�����Ч���Ƿǳ����µ�
	 *   
	 * 2.JDK�ṩ�˶�д����ReentrantReadWriteLock�����Ч�ʣ���ĳЩ����Ҫ����ʵ�������ķ����У�
	 *   ��ȫ����ʹ�ö�д���������÷����������ٶ�
	 *   
	 * 3.��д����ʾ����������һ���Ƕ�������ص�������Ϊ����������һ����д������ص���Ҳ��������;
	 *   �������֮�䲻���⣬��д��дд��д�������ụ�⡣
	 *   
	 * 4.��û���߳̽���д����ʱ�����ж������Ķ���̶߳����Ի�ö�����������д�������߳�ֻ���ڻ�ȡд������ܽ���д�������
	 *   ������߳̿���ͬʱ���ж�����������ͬһʱ��ֻ����һ���߳̽���д����
	 */
	
	public static void main(String[] args) {
		final Service4_17 ser=new Service4_17();
		
		Thread4_17A a=new Thread4_17A(ser);
		a.setName("AAA");
		a.start();
		Thread4_17B b=new Thread4_17B(ser);
		b.setName("BBB");
		b.start();
	}

}
