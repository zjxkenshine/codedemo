package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_13_1 {
	//lockInterruptibly()·½·¨
	
	public ReentrantLock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	
	public void TestMethod() throws InterruptedException{
		try{
			//lock.lock();
			lock.lockInterruptibly();
			System.out.println("lock begin"+Thread.currentThread().getName());
			for(int i=0;i<Integer.MAX_VALUE/10;i++){
				String newString=new String("");
				Math.random();
			}
			System.out.println("lock end"+Thread.currentThread().getName());
		}finally {
			if(lock.isHeldByCurrentThread()){
				lock.unlock();
			}
		}
	}
	
	

}
