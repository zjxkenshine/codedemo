package Chapter4.Object;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service4_19 {
	//ReentrantReadWriteLock类的使用：【读写互斥】
	
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void write(){
		try{
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+"获得写锁，时间"+System.currentTimeMillis());
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.writeLock().unlock();
		}
	}
	

	public void Read(){
		try{
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName()+"获得读锁，时间"+System.currentTimeMillis());
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
	}
	

}
