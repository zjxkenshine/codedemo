package Chapter3.Test;

import Chapter3.Thread.Thread3_20B;
import Chapter3.Thread.Thread3_20C;

public class Test3_20 {
	//方法join与interrupt异常
	
	/**
	 * join()与interrupt()方法叠加使用，会出现异常，但是没有出现异常的线程可以继续运行
	 */
	
	public static void main(String[] args) {
		try{
			Thread3_20B tb=new Thread3_20B();
			tb.start();
			Thread.sleep(500);
			Thread3_20C tc=new Thread3_20C(tb);
			tc.start();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
