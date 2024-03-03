package Chapter1.Test;

import Chapter1.Thread.Thread1_6;

public class Test1_6 {
		//数据共享：非线程安全，两个线程同时对数据处理
	public static void main(String[] args) {
		
		Thread1_6 thread=new Thread1_6();
		Thread a=new Thread(thread,"A");
		Thread b=new Thread(thread,"B");
		Thread c=new Thread(thread,"C");
		Thread d=new Thread(thread,"D");
		Thread e=new Thread(thread,"E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}
