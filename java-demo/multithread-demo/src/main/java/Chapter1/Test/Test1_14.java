package Chapter1.Test;

import Chapter1.Thread.Thread1_14;

public class Test1_14 {
	//getId()方法，获取线程的唯一表示
	public static void main(String[] args) {
		Thread1_14 thread=new Thread1_14();
		thread.setName("线程A");
		thread.start();
		System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getId());
	}

}
