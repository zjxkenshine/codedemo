package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_14 {
	//方法awaitUninterruptibly()的使用
	
	ReentrantLock lock=new ReentrantLock();
	Condition con=lock.newCondition();
	
	public void testMethod(){
		try{
			lock.lock();
			System.out.println("wait begin");
	  //	con.await();
			con.awaitUninterruptibly();
			System.out.println("wait end");
	/*	}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("catch");
	*/	}finally {
			lock.unlock();
		}
	}
	

}
