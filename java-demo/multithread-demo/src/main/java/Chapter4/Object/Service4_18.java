package Chapter4.Object;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service4_18 {
	//ReentrantReadWriteLock类的使用：【写写互斥】
	
	
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void write(){
		try{
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+"获得锁"+System.currentTimeMillis());
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
	}

}
