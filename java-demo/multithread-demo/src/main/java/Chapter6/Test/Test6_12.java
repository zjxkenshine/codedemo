package Chapter6.Test;

import Chapter6.Thread.Thread6_12;

public class Test6_12 {
    //	ʹ��enumö����������ʵ�ֵ���ģʽ
	
	/**
	 * ö��enum�;�̬�������������ƣ���ʹ��ö����ʱ�����췽���ᱻ�Զ����ã�
	 * �������������ʵ�ֵ���ģʽ���
	 * 
	 * ��û�����Ӱ����޷�����
	 * 
	 * �α����Խ����Υ����ְ���һԭ���޸�Ϊ6_13
	 */
	
	public static void main(String[] args) {
		Thread6_12 t1=new Thread6_12();
		Thread6_12 t2=new Thread6_12();
		Thread6_12 t3=new Thread6_12();
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	

}
