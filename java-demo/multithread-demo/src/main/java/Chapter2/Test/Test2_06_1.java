package Chapter2.Test;

import Chapter2.Thread.Thread2_06_1;

public class Test2_06_1 {
	//synchronized��������,�Ǽ̳л���
	
	/**1.��ʹ��synchronizedʱ����һ���̵߳õ�һ������������ٴ�����˶�������ǿ����ٴεõ��ö��������
	 * 
	 * 2.��һ��synchronized����/����ڲ����ñ��������synchronized����/��ʱ������Զ���Եõ�����
	 * 
	 * 3.�����������Լ������ٴλ�ȡ�Լ����ڲ���
	 * 
	 * 4.�����������ڿ��ܻ���֡�������
	 */
	
	public static void main(String[] args) {
		Thread2_06_1 thread=new Thread2_06_1();
		thread.start();
	}

}
