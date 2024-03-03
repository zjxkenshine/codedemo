package Chapter3.Test;

import Chapter3.Thread.Thread3_05A;
import Chapter3.Thread.Thread3_05B;
import Chapter3.Thread.Thread3_05C;
import Chapter3.Thread.Thread3_05Notify;

public class Test3_05 {
	//调用方法notify一次只能通知一个线程并唤醒，notifyAll通知所有
	
	public static void main(String[] args) throws InterruptedException {
		Object lock=new Object();
		Thread3_05A t1=new Thread3_05A(lock);
		t1.start();
		Thread3_05B t2=new Thread3_05B(lock);
		t2.start();
		Thread3_05C t3=new Thread3_05C(lock);
		t3.start();
		
		Thread.sleep(1000);
		Thread3_05Notify tno=new Thread3_05Notify(lock);
		tno.start();
	}

}
