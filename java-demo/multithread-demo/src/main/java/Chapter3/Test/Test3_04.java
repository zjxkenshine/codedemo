package Chapter3.Test;

import Chapter3.Thread.Thread3_04;

public class Test3_04 {
	//interrupt方法遇到wait方法,会报异常
	
	public static void main(String[] args) {
		try{
			Object lock=new Object();
			Thread3_04 t1=new Thread3_04(lock);
			t1.start();
			Thread.sleep(1000);
			t1.interrupt();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
