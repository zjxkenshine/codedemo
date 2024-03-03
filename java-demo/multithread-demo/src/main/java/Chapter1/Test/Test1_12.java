package Chapter1.Test;


import Chapter1.Thread.Thread1_12;

public class Test1_12 {
	//isAlive()的复杂情况，this.isAlive()
	
	public static void main(String[] args) {
		Thread1_12 thread=new Thread1_12();   //未开启，线程未存活
		thread.start();						//只有此时this.Alive()为true
		Thread t=new Thread(thread);           //将thread交给t执行
		System.out.println("begin t isAlive "+t.isAlive());
		t.setName("A");
		t.start();
		System.out.println("end t isAlive "+t.isAlive());
	}

}
