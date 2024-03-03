package Chapter2.Test;

import Chapter2.Thread.Thread2_06_1;

public class Test2_06_1 {
	//synchronized锁的重入,非继承环境
	
	/**1.在使用synchronized时，当一个线程得到一个对象的锁后，再次请求此对象的锁是可以再次得到该对象的锁的
	 * 
	 * 2.在一个synchronized方法/块的内部调用本类的其他synchronized方法/块时，是永远可以得到锁的
	 * 
	 * 3.可重入锁：自己可以再次获取自己的内部锁
	 * 
	 * 4.不可锁重入在可能会出现【锁死】
	 */
	
	public static void main(String[] args) {
		Thread2_06_1 thread=new Thread2_06_1();
		thread.start();
	}

}
