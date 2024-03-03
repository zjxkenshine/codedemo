package Chapter4.Test;

import Chapter4.Object.Service4_12_2;

public class Test4_12_2 {
	//isHeldByCurrentThread()方法
	
	/**boolean lock.isHeldByCurrentThread()方法的作用是查询当前线程是否持有此锁
	 */
	public static void main(String[] args) {
		final Service4_12_2 ser=new Service4_12_2(true);
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.serviceMethod();
			}
		};
		Thread t1=new Thread(runn);
		t1.start();
	}
	
	

}
