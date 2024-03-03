package Chapter4.Object;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_13_3 {
	//tryLock(long timeout,TimeUnit unit)
	
	public ReentrantLock lock=new ReentrantLock();
	public void testMethod(){
		try{
			if(lock.tryLock(3, TimeUnit.SECONDS)){
				System.out.println("     "+Thread.currentThread().getName()+" 获得锁的时间"+System.currentTimeMillis());
	         //改为3秒以内可以获得锁
			}else{
				System.out.println("     "+Thread.currentThread().getName()+"没有获得锁");
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}

}
