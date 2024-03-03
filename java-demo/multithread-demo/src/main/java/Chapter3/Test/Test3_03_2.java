package Chapter3.Test;

import Chapter3.Thread.Thread3_03_2A;
import Chapter3.Thread.Thread3_03_2B;
import Chapter3.Thread.Thread3_03_2C;

public class Test3_03_2 {
	//notify()Ëø²»ÊÍ·Å
	
	public static void main(String[] args) {
		Object lock=new Object();
		Thread3_03_2A t1=new Thread3_03_2A(lock);
		t1.start();
		Thread3_03_2B t2=new Thread3_03_2B(lock);
		t2.start();
		Thread3_03_2C t3=new Thread3_03_2C(lock);
		t3.start();
	}

}
