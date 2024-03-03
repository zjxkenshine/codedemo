package Chapter4.Test;

import Chapter4.Object.Service4_19;
import Chapter4.Thread.Thread4_19A;
import Chapter4.Thread.Thread4_19B;

public class Test4_20 {
	//ReentrantReadWriteLock类的使用：【写读互斥】
	
		/*
		 * 只要出现写操作就互斥,此时读读之间也互斥
		 */
		
		public static void main(String[] args) throws InterruptedException {
			Service4_19 ser=new Service4_19();
			
			Thread4_19B b1=new Thread4_19B(ser);
			b1.setName("B1");
			b1.start();
			Thread4_19B b2=new Thread4_19B(ser);
			b2.setName("B2");
			b2.start();
			Thread.sleep(1000);
			Thread4_19A a=new Thread4_19A(ser);
			a.setName("AA");
			a.start();
			
		}

	
	
	

}
