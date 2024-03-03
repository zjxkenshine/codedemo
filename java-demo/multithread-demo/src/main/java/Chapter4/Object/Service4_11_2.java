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
			System.out.println("��ô�����ڵȴ���condition������̣߳�"+lock.hasWaiters(con)+"    ,�ж��ٸ��߳��ڵȴ���"+lock.getWaitQueueLength(con));
			con.signal();
		}finally {
			lock.unlock();
		}
	}
	
	

}
