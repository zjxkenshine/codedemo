package Chapter3.Test;

import Chapter3.Thread.Thread3_03_1A;
import Chapter3.Thread.Thread3_03_1B;

public class Test3_03_1 {
	//·½·¨wait()ËøÊÍ·Å
	
	public static void main(String[] args) {
		Object lock=new Object();
		Thread3_03_1A t1=new Thread3_03_1A(lock);
		t1.start();
		Thread3_03_1B t2=new Thread3_03_1B(lock);
		t2.start();
	}

}
