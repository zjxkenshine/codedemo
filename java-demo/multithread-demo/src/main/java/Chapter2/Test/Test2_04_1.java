package Chapter2.Test;

import Chapter2.Object.Object2_04_1;
import Chapter2.Thread.Thread2_04_1A;
import Chapter2.Thread.Thread2_04_1B;

public class Test2_04_1 {
	//synchronized方法锁的是这个对象而非方法
	
	/**object对象只有一个方法的情况,同步时排队进行
	 * 
	 * 只有【共享资源】的读写才需要同步化，如果不是共享资源，根本就没有同步的必要
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_04_1 obj=new Object2_04_1();
		Thread2_04_1A a=new Thread2_04_1A(obj);
		a.setName("A");
		Thread2_04_1B b=new Thread2_04_1B(obj);
		b.setName("B");
		a.start();
		b.start();
	}

}
