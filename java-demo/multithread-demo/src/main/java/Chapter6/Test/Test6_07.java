package Chapter6.Test;

import Chapter6.Thread.Thread6_07;

public class Test6_07 {
	//�ӳټ���/����ģʽ��ȱ��Ľ������3������ͬ��,�����Ҫ����ͬ��
	
	/**
	 * δ�����������
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread6_07 t1=new Thread6_07();
		Thread6_07 t2=new Thread6_07();
		Thread6_07 t3=new Thread6_07();
		t1.start();
		t2.start();
		t3.start();
	}
	

	

}
