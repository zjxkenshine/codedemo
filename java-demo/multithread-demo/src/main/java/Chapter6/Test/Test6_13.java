package Chapter6.Test;

import Chapter6.Thread.Thread6_13;

public class Test6_13 {
	//����ʹ��enumö����������ʵ�ֵ���ģʽ
	
	public static void main(String[] args) {
		Thread6_13 t1=new Thread6_13();
		Thread6_13 t2=new Thread6_13();
		Thread6_13 t3=new Thread6_13();
		t1.start();
		t2.start();
		t3.start();
	}

}
