package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_10_1 {
	//getHoldCount()·½·¨
	
	private ReentrantLock lock=new ReentrantLock();
	
	public void Method1(){
		try{
			lock.lock();
			System.out.println("Method1 getHoldCount="+lock.getHoldCount());
			Method2();
		}finally {
			lock.unlock();
		}
	}

	private void Method2() {
		// TODO Auto-generated method stub
		try{
			lock.lock();
			System.out.println("Method2 getHoldCount="+lock.getHoldCount());
			Method3();
		}finally {
			lock.unlock();
		}
		
	}

	private void Method3() {
		// TODO Auto-generated method stub
		try{
			lock.lock();
			System.out.println("Method3 getHoldCount="+lock.getHoldCount());
		}finally {
			lock.unlock();
		}
	}

}
