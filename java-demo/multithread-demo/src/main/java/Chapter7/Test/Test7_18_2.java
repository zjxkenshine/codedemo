package Chapter7.Test;

import Chapter7.Object.ObjectUncaughtExceptionHandler;
import Chapter7.Object.StateUncaughtExceptionHandler;
import Chapter7.Thread.Thread7_18;
import Chapter7.Thread.ThreadGroup7_18;

public class Test7_18_2 {
	
	/**
	 * 有对象只执行对象
	 * 无对象执行静态类以及线程组的异常
	 * @param args
	 */
	
	public static void main(String[] args) {
		ThreadGroup7_18 tg=new ThreadGroup7_18("wod线程组");
		
		Thread7_18 th=new Thread7_18(tg,"线程1");
		
		//对象
		//th.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());  //注释掉这一行
		
		//类
		Thread7_18.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		th.start();
		
	}

}
