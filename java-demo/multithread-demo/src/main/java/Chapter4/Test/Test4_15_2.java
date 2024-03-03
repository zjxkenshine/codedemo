package Chapter4.Test;

import Chapter4.Object.Service4_15;
import Chapter4.Thread.Thread4_15A;
import Chapter4.Thread.Thread4_15B;

public class Test4_15_2 {
	//方法awaitUntil()的使用
	
	/**
	 * 强制唤醒
	 * @param args
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_15 ser=new Service4_15();
		Thread4_15A t1=new Thread4_15A(ser);
		t1.start();
		Thread.sleep(2000);
		Thread4_15B t2=new Thread4_15B(ser);
		t2.start();
	}

}
