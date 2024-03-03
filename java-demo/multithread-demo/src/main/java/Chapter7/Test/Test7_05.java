package Chapter7.Test;

import Chapter7.Thread.Thread7_05A;
import Chapter7.Thread.Thread7_05B;

public class Test7_05 {
	//线程对象关联线程组：一级关联
	
	/**1.可以把线程归属到某一个线程组中，线程组中可以有线程对象也可以有线程组,组中还可以有线程
	 * 
	 * 2.线程组的作用是，可以批量管理线程或线程组,有效地对线程或线程组对象进行组织
	 * 
	 * 3.1级关联：所谓的1级关联就是父对象中有子对象，但是并不创建子孙对象。
	 *   这种情况常出现在开发中。比如创建一些线程时，为了有效对这些线程进行组织管理，
	 *   通常情况下是创建一个线程组，然后再将部分线程归属到该组中。
	 *   这样处理可以对零散的线程对象进行有效的组织与规划。
	 * 
	 */
	
	public static void main(String[] args) {
		Thread7_05A t1=new Thread7_05A();
		Thread7_05B t2=new Thread7_05B();
		ThreadGroup tg=new ThreadGroup("666组");
		
		Thread t11=new Thread(tg,t1);
		Thread t22=new Thread(tg,t2);
		
		t11.start();
		t22.start();
		
		System.out.println("活动线程数为："+tg.activeCount());
		System.out.println("线程组的名称为："+tg.getName());
	}

}
