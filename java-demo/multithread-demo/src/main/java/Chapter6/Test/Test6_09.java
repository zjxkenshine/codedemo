package Chapter6.Test;

import Chapter6.Thread.Thread6_09;

public class Test6_09 {
	//ʹ�þ�̬������ʵ�ֵ���ģʽ
	
	public static void main(String[] args) {
		Thread6_09 t1=new Thread6_09();
		Thread6_09 t2=new Thread6_09();
		Thread6_09 t3=new Thread6_09();
		t1.start();
		t2.start();
		t3.start();
	}
	

}
