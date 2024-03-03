package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_12_3 {
	//isLocked()·½·¨
	
	private ReentrantLock lock=new ReentrantLock();
	
	public Service4_12_3(boolean isFair) {
		// TODO Auto-generated constructor stub
		lock=new ReentrantLock(isFair);
	}
	
	public void TestMethod(){
		try{
			System.out.println(lock.isLocked());
			System.out.println(lock.isHeldByCurrentThread());
			lock.lock();
			System.out.println(lock.isLocked());
			System.out.println(lock.isHeldByCurrentThread());
		}finally {
			lock.unlock();
			System.out.println(lock.isLocked());
			System.out.println(lock.isHeldByCurrentThread());
		}
	}
	

}
