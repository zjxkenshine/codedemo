package Chapter6.Test;

import Chapter6.Thread.Thread6_02;

public class Test6_02 {
	//��������/����ģʽ
	
	/*�������ؾ���ʹ�����ʱ���Ѿ������󴴽�����ˣ�������ʵ�ַ�������newʵ����
	 * 
	 *��������/����ģʽ���ڵ��÷���ǰ��ʵ�����Ѿ���������
	 * 
	 */
	
	public static void main(String[] args) {
		Thread6_02 t1=new Thread6_02();
		Thread6_02 t2=new Thread6_02();
		Thread6_02 t3=new Thread6_02();
		t1.start();
		t2.start();
		t3.start();
		//�õ���hashCode��ͬһ����˵����ͬһ������
	}
	
	

}
