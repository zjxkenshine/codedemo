package Chapter3.Test;

import Chapter3.Object.Object3_02_4;
import Chapter3.Thread.Thread3_02_4A;
import Chapter3.Thread.Thread3_02_4B;

public class Test3_02_4 {
	//wait与notify实现size=5的实验
	
	/**1.关键字synchronized会把任何一个Object对象作为同步对象看待
	 * 
	 * 2.被重新唤醒的线程会试图重新获取临界区的锁，并执行临界区（wait）后的代码
	 *   如果发出notify时没有处与wait的线程，那么该命令会被忽略
	 * 
	 * 3.notify方法可以唤醒等待队列中的一个线程，并使该线程退出等待成为可运行状态，只通知一个
	 * 
	 * 4.notifyAll:通知所有wait的线程
	 */
	
	public static void main(String[] args) {
		try{
			Object obj=new Object();
			Thread3_02_4A t1=new Thread3_02_4A(obj);
			t1.start();
			Thread.sleep(1000);
			Thread3_02_4B t2=new Thread3_02_4B(obj);
			t2.start();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}