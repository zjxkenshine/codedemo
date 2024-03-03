package Chapter1.Test;

import Chapter1.Thread.Thread1_5;

public class Test1_5 {
	//数据不共享
	public static void main(String[] args) {
		Thread1_5 a=new Thread1_5("A");
		Thread1_5 b=new Thread1_5("B");
		Thread1_5 c=new Thread1_5("C");
		a.start();
		b.start();
		c.start();
	}
}
