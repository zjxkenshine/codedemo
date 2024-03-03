package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_12_1 {
	//isFair()方法
	
    private ReentrantLock lock;
	
	public Service4_12_1(boolean isFair){
		super();
		lock=new ReentrantLock(isFair);
	}
	
	public void TestMethod(){
		try{
			lock.lock();
			System.out.println("公平锁情况："+lock.isFair());
		}finally {
			lock.unlock();
		}
	}

}
