package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_13_2 {
	//tryLock()方法
	
	public ReentrantLock lock=new ReentrantLock();
	public void Method(){
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName()+" 获得锁");
		}else{
			System.out.println(Thread.currentThread().getName()+" 没有获得锁");
		}
	}

}
