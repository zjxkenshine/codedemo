package Chapter1.Test;

import Chapter1.Thread.Thread1_8;

public class Test1_8 {
	//i++,i--与println(同步方法)连用，出现另一种异常
	public static void main(String[] args) {
		Thread1_8 thread=new Thread1_8();
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
