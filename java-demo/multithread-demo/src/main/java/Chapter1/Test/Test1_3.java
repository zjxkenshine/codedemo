package Chapter1.Test;

import Chapter1.Thread.Thread1_3;

public class Test1_3 {
	//线程不确定性：调用Start方法顺序不是线程执行顺序
	public static void main(String[] args) {
		Thread1_3 t1 =new Thread1_3(1);
		Thread1_3 t2 =new Thread1_3(2);
		Thread1_3 t3 =new Thread1_3(3);
		Thread1_3 t4 =new Thread1_3(4);
		Thread1_3 t5 =new Thread1_3(5);
		Thread1_3 t6 =new Thread1_3(6);
		Thread1_3 t7 =new Thread1_3(7);
		Thread1_3 t8 =new Thread1_3(8);
		Thread1_3 t9 =new Thread1_3(9);
		Thread1_3 t10 =new Thread1_3(10);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		
		//输出结果与start执行顺序不同
	}
	
}
