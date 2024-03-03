package Chapter6.Test;

import Chapter6.Thread.Thread6_07;

public class Test6_07 {
	//延迟加载/懒汉模式的缺点的解决方法3：部分同步,针对重要代码同步
	
	/**
	 * 未解决根本问题
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread6_07 t1=new Thread6_07();
		Thread6_07 t2=new Thread6_07();
		Thread6_07 t3=new Thread6_07();
		t1.start();
		t2.start();
		t3.start();
	}
	

	

}
