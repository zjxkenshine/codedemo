package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_03_1 {
	//使用Condition实现等待/通知：错误的用法及解决
	
	private Lock lock=new ReentrantLock();
	private Condition con=lock.newCondition();
	
	public void await(){
		try{
			con.await();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
