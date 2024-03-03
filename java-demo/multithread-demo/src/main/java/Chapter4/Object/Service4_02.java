package Chapter4.Object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_02 {
	
	private Lock lock=new ReentrantLock();
	
	public void MethodA(){
		try{
			lock.lock();
			System.out.println("methodA begin ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println("methodA end ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void MethodB(){
	try{
		lock.lock();
		System.out.println("methodB begin ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		Thread.sleep(2000);
		System.out.println("methodB end ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		
	}catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		lock.unlock();
	}
	}

}
