package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_06 {
	//��ȷʹ�ö��Conditionʵ��֪ͨ�����߳�
	
	private Lock lock=new ReentrantLock();
	
	public Condition conditionA=lock.newCondition();
	public Condition conditionB=lock.newCondition();
	
	public void awaitA(){
		try{
			lock.lock();
			System.out.println("begin awaitA��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			Thread.sleep(2000);
			conditionA.await();
			System.out.println("end awaitA��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void awaitB(){
		try{
			lock.lock();
			System.out.println("begin awaitB��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			
			conditionA.await();
			System.out.println("end awaitB��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void signalA(){
		try{
			lock.lock();
			System.out.println("signalA begin��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionA.signal();
		}finally {
			lock.lock();
		}
	}
	
	public void signalB(){
		try{
			lock.lock();
			System.out.println("signalBbegin��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			conditionA.signal();
		}finally {
			lock.lock();
		}
	}

}
