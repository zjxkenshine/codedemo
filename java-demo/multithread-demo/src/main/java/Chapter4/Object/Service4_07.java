package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_07 {
  //实现生产者/消费者模式：一对一打印
	
	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	private boolean value=false;
	public void set(){
		try{
			lock.lock();
			while(value==true){
				condition.await();
			}
			System.out.println("打印11111111111");
			value=true;
			condition.signal();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void get(){
		try{
			lock.lock();
			while(value==false){
				condition.await();
			}
			System.out.println("打印22222222222");
			value=false;
			condition.signal();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

}
