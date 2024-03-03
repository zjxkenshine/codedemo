package Chapter4.Test;

import Chapter4.Object.Service4_14;
import Chapter4.Thread.Thread4_14;

public class Test4_14 {
	//方法awaitUninterruptibly()的使用
	
	/**
	 * awaitUninterruptibly()作用与await相同，但是遇到interrupt时不会报错
	 */
	
	public static void main(String[] args) {
		try{
			Service4_14 ser=new Service4_14();
			Thread4_14 t1=new Thread4_14(ser);
			t1.start();
			Thread.sleep(3000);
			t1.interrupt();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
