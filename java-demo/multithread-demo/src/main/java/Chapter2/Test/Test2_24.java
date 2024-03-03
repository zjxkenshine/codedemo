package Chapter2.Test;

import Chapter2.Thread.Thread2_24;

public class Test2_24 {
	//多线程的死锁
	
	/**
	 * 死锁：等待不可能被释放的锁，从而导致所有任务无法继续完成
	 * 
	 * 死锁是必须避免的，会造成线程的假死
	 * 
	 * 只要互相等待对方就有可能造成死锁
	 * @throws InterruptedException 
	 * 
	 */
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread2_24 t=new Thread2_24();
		t.setFlag("a");
		Thread a=new Thread(t);
		a.start();
		Thread.sleep(100);
		t.setFlag("b");
		Thread b=new Thread(t);
		b.start();
	}

}
