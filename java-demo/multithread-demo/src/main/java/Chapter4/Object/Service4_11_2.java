package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_11_2 {
	
	public ReentrantLock lock=new ReentrantLock();
	public Condition con=lock.newCondition();
	
	public void waitMethod(){
		try{
			lock.lock();
			con.await();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void notifyMethod(){
		try{
			lock.lock();
			System.out.println("有么有正在等待该condition对象的线程："+lock.hasWaiters(con)+"    ,有多少个线程在等待："+lock.getWaitQueueLength(con));
			con.signal();
		}finally {
			lock.unlock();
		}
	}
	
	

}
