package Chapter3.Test;

import Chapter3.Thread.Thread3_22A;
import Chapter3.Thread.Thread3_22B;
import Chapter3.Thread.Thread3_22C;

public class Test3_22 {
	// join(long)与sleep(long)的区别
	
	/**join(long):内部wait(long)实现，执行后当前锁被释放，其他线程可以调用此线程中的同步方法
	 * Thread.sleep(long):不释放锁
	 * 
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_22B tb=new Thread3_22B();
			Thread3_22A ta=new Thread3_22A(tb);
			ta.start();
			Thread.sleep(2000);
			Thread3_22C tc=new Thread3_22C(tb);
			tc.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
