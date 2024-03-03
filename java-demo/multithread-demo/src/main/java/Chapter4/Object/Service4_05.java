package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_05 {
	//ʹ�ö��Conditionʵ��֪ͨ�����߳�ʱ�Ĵ����÷�
	
	private Lock lock=new ReentrantLock();
	
	public  Condition condition=lock.newCondition();
	
	public void awaitA(){
		try{
			lock.lock();
			System.out.println("begin awaitA��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.await();
			System.out.println("end awaitA��ʱ��Ϊ"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void awaitB(){
		try{
			lock.lock();
			System.out.println("begin awaitB��ʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.await();
			System.out.println("end awaitB��ʱ��Ϊ"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void signalAll(){
		try{
			lock.lock();
			System.out.println(" singnalAllʱ��Ϊ"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.signalAll();
		}finally {
			lock.unlock();
		}
	}

}
