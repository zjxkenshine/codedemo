package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_10_2 {
	public ReentrantLock lock=new ReentrantLock();
	
	public void TestMethod(){
		try{
		    lock.lock();
		    System.out.println("ThreadName="+Thread.currentThread().getName()+" 进入方法");
		    Thread.sleep(Integer.MAX_VALUE);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

}
