package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_04 {
	//正确使用Condition实现等待/通知
	
	private Lock lock=new ReentrantLock();
	public Condition con=lock.newCondition();
	
	public void await(){
		try{
			lock.lock();
			System.out.println("等待时间为"+System.currentTimeMillis());
			con.await();
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
			
		}
	}
	
	//通知方法
	public void signal(){
		try{
			lock.lock();
			System.out.println("通知时间为"+System.currentTimeMillis());
			con.signal();
			
		}finally {
			lock.unlock();
		}
	}

}
