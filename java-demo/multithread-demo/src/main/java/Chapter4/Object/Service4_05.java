package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_05 {
	//使用多个Condition实现通知部分线程时的错误用法
	
	private Lock lock=new ReentrantLock();
	
	public  Condition condition=lock.newCondition();
	
	public void awaitA(){
		try{
			lock.lock();
			System.out.println("begin awaitA的时间为"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.await();
			System.out.println("end awaitA的时间为"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
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
			System.out.println("begin awaitB的时间为"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.await();
			System.out.println("end awaitB的时间为"+System.currentTimeMillis()+"ThreadName="+Thread.currentThread().getName());
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
			System.out.println(" singnalAll时间为"+System.currentTimeMillis()+" ThreadName="+Thread.currentThread().getName());
			condition.signalAll();
		}finally {
			lock.unlock();
		}
	}

}
