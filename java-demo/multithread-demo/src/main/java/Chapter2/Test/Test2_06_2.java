package Chapter2.Test;

import Chapter2.Thread.Thread2_06_2;

public class Test2_06_2 {
	//synchronized锁的重入,继承环境
	
	/**
	 * 当存在父子类继承关系时，子类完全可以通过【可重入锁】调用父类的同步方法
	 */
	
	public static void main(String[] args) {
		Thread2_06_2 thread=new Thread2_06_2();
		thread.start();
	}
}
