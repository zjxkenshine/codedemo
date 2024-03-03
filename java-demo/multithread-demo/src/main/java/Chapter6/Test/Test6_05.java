package Chapter6.Test;

import Chapter6.Thread.Thread6_05;

public class Test6_05 {
	//延迟加载/懒汉模式的缺点的解决方法1：声明synchronize关键字
	
	/**
	 * 多个线程可以同时进入getInstance方法，只要对getInstance方法声明synchronized关键字即可
	 * 
	 * 这种方法的效率非常低下，同步运行，下一个线程想要取得对象，必须等上一个线程释放锁之后才可以执行
	 */
	
	public static void main(String[] args) {
		Thread6_05 t1=new Thread6_05();
		Thread6_05 t2=new Thread6_05();
		Thread6_05 t3=new Thread6_05();
		t1.start();
		t2.start();
		t3.start();
		
	}

}
