package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_12_2 {
	//isHeldByCurrentThread()·½·¨
	
	private ReentrantLock lock;
	public Service4_12_2(boolean isFair){
		super();
		lock=new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try{
			System.out.println(lock.isHeldByCurrentThread());
			lock.lock();
			System.out.println(lock.isHeldByCurrentThread());
		}finally {
			lock.unlock();
			System.out.println(lock.isHeldByCurrentThread());
		}
	}

}
