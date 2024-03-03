package Chapter4.Test;

import Chapter4.Object.Service4_19;
import Chapter4.Thread.Thread4_19A;
import Chapter4.Thread.Thread4_19B;

public class Test4_19 {
	//ReentrantReadWriteLock类的使用：【读写互斥】
	
	/*
	 * 只要出现写操作就互斥
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_19 ser=new Service4_19();
		
		Thread4_19A a=new Thread4_19A(ser);
		a.setName("AAA");
		a.start();
		
		Thread.sleep(1000);
		
		Thread4_19B b=new Thread4_19B(ser);
		b.setName("BBB");
		b.start();
	}

}
