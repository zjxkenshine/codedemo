package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_10_3 {
	//getWaitQueueLength()����
	
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
			System.out.println("��"+lock.getWaitQueueLength(con)+"���߳����ڵȴ�con");
			con.signal();
		}finally {
			lock.unlock();
		}
	
		
	}

}
