package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_09 {
	//公平锁与非公平锁
	
	private ReentrantLock lock;
	
	public Service4_09(boolean isfair) {
		// TODO Auto-generated constructor stub
		super();
		lock=new ReentrantLock(isfair);
	}
	
	public void Method(){
		try{
			lock.lock();
			System.out.println("ThreadName="+Thread.currentThread().getName()+" 得到锁");
		}finally {
			lock.unlock();
		}
	}
	

}
