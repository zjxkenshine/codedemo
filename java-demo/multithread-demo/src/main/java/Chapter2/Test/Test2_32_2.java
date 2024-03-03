package Chapter2.Test;

import Chapter2.Thread.Thread2_32_2;

public class Test2_32_2 {
	//volatile的非原子特性
	
	/**1.关键字volatile使用的场合时在多个线程中可以感知实例变量被更改了，并且可以获得最新的值使用，
	 *  	也就是用【多线程读取共享变量时】可以获得最新的值使用
	 * 
	 * 2.关键字volatile提示线程每次从共享内存中读数据而不是私有内存，实现了同步数据的可见性
	 * 
	 * 3.如果修改了实例变量中的数据为i++,这样的操作不是一个原子操作，也就是非线程安全的
	 * 
	 * 4.volatile关键字本身并不处理数据的原子性，而是强制对数据的读写及时影响到主内存的
	 * 
	 * 5.多线程访问同一个变量还是要加同步锁，(书P126)
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Thread2_32_2[] a=new Thread2_32_2[100];
		for(int i=0;i<100;i++){
			a[i]=new Thread2_32_2();
		}
		
		for(int i=0;i<100;i++){
			a[i].start();
		}
	}

}
