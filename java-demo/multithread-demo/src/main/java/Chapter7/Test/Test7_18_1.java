package Chapter7.Test;

import Chapter7.Object.ObjectUncaughtExceptionHandler;
import Chapter7.Object.StateUncaughtExceptionHandler;
import Chapter7.Thread.Thread7_18;

public class Test7_18_1 {
	//线程异常处理的传递
	
	/**
	 * 对类与对象一起添加默认的处理，遇到时只执行对象的 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread7_18 th=new Thread7_18();
		
		//对象
		th.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());  //注释掉这一行
		
		//类
		Thread7_18.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
		
		th.start();
		
	}

}
