package Chapter7.Test;

import java.lang.Thread.UncaughtExceptionHandler;

import Chapter7.Thread.Thread7_16;

public class Test7_16_3 {
	//线程中出现异常的处理
	
	/**
	 * 方法setUncaughtExceptionHandler(UncaughtExceptionHandler)是给指定线程对象设置异常处理器，还可以使用
	 * 方法setDefaultExceptionHandler(UncaughtExceptionHandler)的作用是为【指定线程类的所有线程对象】设置默认的线程处理器
	 */
	
	public static void main(String[] args) {
		
		
		    UncaughtExceptionHandler eh= new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// 异常处理器
				System.out.println("线程："+t.getName()+"   出现异常：");
				e.printStackTrace();
			}
		    };
		    
		    
		    Thread7_16.setDefaultUncaughtExceptionHandler(eh);
		    
		    Thread7_16 t1=new Thread7_16();
		    t1.setName("线程t1");
		    t1.start();
		    Thread7_16 t2=new Thread7_16();
		    t2.setName("线程t2");
		    t2.start();
	
	}

}
