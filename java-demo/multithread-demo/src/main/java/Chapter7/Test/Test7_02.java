package Chapter7.Test;

import Chapter7.Thread.Thread7_02;

public class Test7_02 {
	//验证TIMED_WAITING状态
	
	/**
	 * 线程状态TIMED_WAITING代表线程执行了Thread.sleep()方法，呈等待状态，等待时间到达，继续向下执行
	 * 
	 * 执行sleep方法后状态的枚举值就变为了TIMED_WAITING
	 */
	
	public static void main(String[] args) {
		try{
			Thread7_02 t1=new Thread7_02();
			t1.start();
			Thread.sleep(1000);
			System.out.println("main方法中的状态"+t1.getState());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
