package Chapter6.Test;

import Chapter6.Thread.Thread6_03;

public class Test6_03 {
	//�ӳټ���/����ģʽ����
	
	/**
	 * �ӳټ��ؾ����ڵ���get����ʱʵ���ű�������������ʵ�ַ���ʱ��get�����н���newʵ����
	 * 
	 * �ӳټ���/����ģʽ���ڵ��÷���ʱʵ���ű�����
	 * 
	 * �ڶ��̻߳����оͻ�ȡ����������뵥��ģʽ�ĳ������
	 */
	
	
	public static void main(String[] args) {
		Thread6_03 t1=new Thread6_03();
		Thread6_03 t2=new Thread6_03();
		t1.start();
		t2.start();
	}
	

}
