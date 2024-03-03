package Chapter7.Test;

import java.lang.Thread.UncaughtExceptionHandler;

import Chapter7.Thread.Thread7_16;

public class Test7_16_2 {
	//线程中出现异常的处理
	
	/**
	 * 方法setUncaughtExceptionHandler(UncaughtExceptionHandler)的作用是对【指定的线程对象】设置默认的异常处理器
	 * @param args
	 */
	
	public static void main(String[] args) {
		Thread7_16 t1=new Thread7_16();
		t1.setName("线程1");
		
		
		
		UncaughtExceptionHandler eh=new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("线程："+t.getName()+"   出现异常：");
				e.printStackTrace();
			}
		};
		t1.setUncaughtExceptionHandler(eh);
		
		
		t1.start();
		Thread7_16 t2=new Thread7_16();
		t2.start();
		t2.start();
		
		
		
	}

}
