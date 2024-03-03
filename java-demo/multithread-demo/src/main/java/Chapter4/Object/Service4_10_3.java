package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_10_3 {
	//getWaitQueueLength()方法
	
	private ReentrantLock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	
	public void WaitMethod(){
		try{
			lock.lock();
			con.await();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void SingalMethod(){
		try{
			lock.lock();
			System.out.println("有"+lock.getWaitQueueLength(con)+"个线程正在等待con");
			con.signal();
		}finally {
			lock.unlock();
		}
	
		
	}

}
