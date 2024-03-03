package Chapter4.Object;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service4_17 {
	//ReentrantReadWriteLock���ʹ�ã�����������
	
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void read(){
		try{
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName()+"�����"+System.currentTimeMillis());
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
	}

}
