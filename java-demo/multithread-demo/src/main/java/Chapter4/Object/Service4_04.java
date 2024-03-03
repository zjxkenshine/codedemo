package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_04 {
	//��ȷʹ��Conditionʵ�ֵȴ�/֪ͨ
	
	private Lock lock=new ReentrantLock();
	public Condition con=lock.newCondition();
	
	public void await(){
		try{
			lock.lock();
			System.out.println("�ȴ�ʱ��Ϊ"+System.currentTimeMillis());
			con.await();
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
			
		}
	}
	
	//֪ͨ����
	public void signal(){
		try{
			lock.lock();
			System.out.println("֪ͨʱ��Ϊ"+System.currentTimeMillis());
			con.signal();
			
		}finally {
			lock.unlock();
		}
	}

}
