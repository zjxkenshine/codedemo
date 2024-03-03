package Chapter1.Test;

import Chapter1.Thread.Thread1_10;

public class Test1_10 {
	//this.getName()与thread.currentThread.getName()的区别
	public static void main(String[] args) {
		Thread1_10 thread=new Thread1_10();    
		Thread t=new Thread(thread);           //将thread交给t执行
		t.setName("A");
		t.start();
	}
}
