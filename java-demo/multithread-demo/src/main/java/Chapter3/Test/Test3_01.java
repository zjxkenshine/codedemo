package Chapter3.Test;

import Chapter3.Object.Object3_01;
import Chapter3.Thread.Thread3_01A;
import Chapter3.Thread.Thread3_01B;

public class Test3_01 {
	//��ʹ�õȴ�/֪ͨ����ʵ���߳�ͨ��
	
	/**1.�߳����߳�֮�䲻�Ƕ����ĸ��壬���Ǳ˴�֮����Ի���ͨ�ź�Э��
	 * 
	 * 2.������sleep����ѭ�������ʵ��ͨ�š�
	 * 
	 * 3.�׶ˣ�
	 *  a.��Ȼʵ����ͨ�ţ���ThreadB����ͨ��whileѭ�������ĳһ�����������������cpu�˷�
	 *  b.��ѯʱ����С�����˷�cpu��Դ����ѯʱ����̫���п��ܻ�ȡ�����벻��������
	 *  
	 *  4.����Ч�ʵķ���ʵ�ֶ���̼߳�ͨ�ţ��ȴ�/֪ͨ����
	 *  
	 *  5.����̷߳���ͬһ������ʵ���߳�ͨ�Ų���"�ȴ�/֪ͨ"����
	 * 
	 */
	
	public static void main(String[] args) {
		Object3_01 obj=new Object3_01();
		Thread3_01A thread1=new Thread3_01A(obj);
		thread1.setName("A");
		thread1.start();
		Thread3_01B thread2=new Thread3_01B(obj);
		thread2.setName("B");
		thread2.start();
	}

}
