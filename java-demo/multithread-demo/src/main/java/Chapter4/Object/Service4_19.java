package Chapter4.Object;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service4_19 {
	//ReentrantReadWriteLock���ʹ�ã�����д���⡿
	
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	public void write(){
		try{
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+"���д����ʱ��"+System.currentTimeMillis());
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
			System.out.println(Thread.currentThread().getName()+"��ö�����ʱ��"+System.currentTimeMillis());
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.readLock().unlock();
		}
	}
	

}
