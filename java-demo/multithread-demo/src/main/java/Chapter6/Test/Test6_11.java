package Chapter6.Test;

import Chapter6.Thread.Thread6_11;

public class Test6_11 {
	//使用static代码实现单例模式
	
	//同一个对象
	
	public static void main(String[] args) {
		Thread6_11 t1=new Thread6_11();
		Thread6_11 t2=new Thread6_11();
		Thread6_11 t3=new Thread6_11();
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
