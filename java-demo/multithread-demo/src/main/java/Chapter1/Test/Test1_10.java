package Chapter1.Test;

import Chapter1.Thread.Thread1_10;

public class Test1_10 {
	//this.getName()��thread.currentThread.getName()������
	public static void main(String[] args) {
		Thread1_10 thread=new Thread1_10();    
		Thread t=new Thread(thread);           //��thread����tִ��
		t.setName("A");
		t.start();
	}
}
