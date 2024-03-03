package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_11_1 {
	public ReentrantLock lock=new ReentrantLock();
	public Condition con=lock.newCondition();
	public void waitMethod(){
		try{
			lock.lock();
			Thread.sleep(Integer.MAX_VALUE);
		}catch(InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}
