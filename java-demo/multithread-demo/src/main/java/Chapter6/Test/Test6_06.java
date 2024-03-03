package Chapter6.Test;

import Chapter6.Thread.Thread6_06;

public class Test6_06 {
	//延迟加载/懒汉模式的缺点的解决方法2：使用同步代码块
	
	/**
	 * 使用同步代码块缺点和synchronized方法一样，效率低
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread6_06 t1=new Thread6_06();
		Thread6_06 t2=new Thread6_06();
		Thread6_06 t3=new Thread6_06();
		t1.start();
		t2.start();
		t3.start();
	}

}
