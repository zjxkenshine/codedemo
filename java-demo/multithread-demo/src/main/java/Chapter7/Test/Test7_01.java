package Chapter7.Test;

import Chapter7.Thread.Thread7_01;

public class Test7_01 {
	//验证NEW,RUNNABLE和TERMINATED状态
	
	/**
	 * NEW状态是实例化后未执行run的状态，RUNNABLE是线程进入运行时的状态，
	 * TERMINATED状态是线程销毁时的状态
	 * 
	 * 使用getState()可以查看状态
	 */
	
	public static void main(String[] args) {
		try{
			Thread7_01 t1=new Thread7_01();
			System.out.println("main方法中的状态1："+t1.getState());
			Thread.sleep(1000);
			t1.start();
			Thread.sleep(1000);
			System.out.println("main方法中的状态2："+t1.getState());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
