package Chapter4.Object;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service4_17 {
	//ReentrantReadWriteLock类的使用：【读读共享】
	
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void read(){
		try{
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName()+"获得锁"+System.currentTimeMillis());
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
	}

}
