package Chapter4.Test;

import Chapter4.Object.Service4_03_1;
import Chapter4.Thread.Thread4_03_1;

public class Test4_03_1 {
	//ʹ��Conditionʵ�ֵȴ�/֪ͨ��������÷������
	
	/**1.�ؼ���synchronized��wait()��notify()/notifyAll()�������ʹ�ÿ���ʵ��ͬ���Ĺ��ܣ�����Ҫ������condition����
	 * 
	 * 2.condition����JDK5�г��ֵļ�����ʹ�����и��õ�����ԣ�����ʵ�ֶ�ͨ·֪ͨ���ܣ�
	 *   Ҳ������һ��Lock��������Դ������Condition(���������)ʵ�����̶߳������ע����ָ����Condition��
	 *   �Ӷ�������ѡ���Եؽ���֪ͨ�̣߳��ڵ����߳��ϸ�����
	 *   
	 * 3.��ʹ��notify/notifyAll��������֪ͨʱ����֪ͨ���߳�ȴ����JVM���ѡ��ġ�
	 *   ����ʹ��ReentrantLock���Condition�����ʵ��ѡ����֪ͨ�����������ConditionĬ���ṩ��
	 *   
	 * 4.synchronize�൱������Lock������ֻ�е�һ��Condition���������̶߳�ע������һ���������ϡ�
	 *   �߳̿�ʼnotifyAll()ʱ����Ҫ֪ͨ���еȴ����̣߳�û��ѡ���ܣ�����ֺܴ��Ч�����⡣
	 * 
	 */
	
	//�����ӳ���ԭ���Ǳ����ڵ���await()����ǰʹ��lock.lock���ͬ��������
	//�޸ĺ������Ϊ4_03_2
	public static void main(String[] args) {
		Service4_03_1 ser=new Service4_03_1();
		Thread4_03_1 t1=new Thread4_03_1(ser);
		t1.start();
	}
	
	
	
	

}
