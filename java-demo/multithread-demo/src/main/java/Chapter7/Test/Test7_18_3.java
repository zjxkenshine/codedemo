package Chapter7.Test;

import Chapter7.Thread.Thread7_18;
import Chapter7.Thread.ThreadGroup7_18;

public class Test7_18_3 {
	//线程异常处理的传递
	
	/**
	 * 想要打印出静态处理的信息必须在 uncaughtException(Thread t, Throwable e)中加上uncautException(t,e)
	 */
	public static void main(String[] args) {
		ThreadGroup7_18 tg=new ThreadGroup7_18("wod线程组");
		
		Thread7_18 th=new Thread7_18(tg,"线程1");
		th.start();
	}
	

}
