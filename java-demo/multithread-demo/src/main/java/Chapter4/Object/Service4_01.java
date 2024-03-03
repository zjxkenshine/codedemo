package Chapter4.Object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_01 {
	//使用ReentratLock实现同步：测试1
	
	private Lock lock=new ReentrantLock();
	
	public void testMethod(){
		lock.lock();             //锁开始
		for(int i=0;i<5;i++){
			System.out.println("ThreadName="+Thread.currentThread().getName()+(" "+(i+1)));
		}
		lock.unlock();           //释放锁
	}

}
