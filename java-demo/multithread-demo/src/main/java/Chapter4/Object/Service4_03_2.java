package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_03_2 {
	

	private Lock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	
	public void await(){
		try{
			lock.lock();
			System.out.println("11111111111111111");
			con.await();
			System.out.println("22222222222222222");
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("À¯ Õ∑≈¡À");
		}
	}

}
