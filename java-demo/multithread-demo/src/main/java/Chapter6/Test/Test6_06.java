package Chapter6.Test;

import Chapter6.Thread.Thread6_06;

public class Test6_06 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������2��ʹ��ͬ�������
	
	/**
	 * ʹ��ͬ�������ȱ���synchronized����һ����Ч�ʵ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread6_06 t1=new Thread6_06();
		Thread6_06 t2=new Thread6_06();
		Thread6_06 t3=new Thread6_06();
		t1.start();
		t2.start();
		t3.start();
	}

}
