package Chapter4.Test;

import Chapter4.Object.Service4_18;
import Chapter4.Thread.Thread4_18A;
import Chapter4.Thread.Thread4_18B;

public class Test4_18 {
	//ReentrantReadWriteLock类的使用：【写写互斥】
	
	public static void main(String[] args) {
		final Service4_18 ser=new Service4_18();
		
		Thread4_18A a=new Thread4_18A(ser);
		a.setName("AAA");
		a.start();
		Thread4_18B b=new Thread4_18B(ser);
		b.setName("BBB");
		b.start();
	}

}
