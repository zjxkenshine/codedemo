package Chapter4.Object;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_15 {
	//方法awaitUntil()的使用
	
	private ReentrantLock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	
	public void waitMethod(){
		try{
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.SECOND, 10);
			
			lock.lock();
			System.out.println("wait begin time="+System.currentTimeMillis());
			con.awaitUntil(cal.getTime());
			
			System.out.println("wait end time="+System.currentTimeMillis());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void notifyMethod(){
		try{
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.SECOND, 10);
			
			lock.lock();
			System.out.println("notify begin time="+System.currentTimeMillis());
			con.signalAll();
			System.out.println("notify end time="+System.currentTimeMillis());
		}finally {
			lock.unlock();
		}
	}

}
