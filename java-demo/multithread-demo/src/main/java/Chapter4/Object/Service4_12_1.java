package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_12_1 {
	//isFair()����
	
    private ReentrantLock lock;
	
	public Service4_12_1(boolean isFair){
		super();
		lock=new ReentrantLock(isFair);
	}
	
	public void TestMethod(){
		try{
			lock.lock();
			System.out.println("��ƽ�������"+lock.isFair());
		}finally {
			lock.unlock();
		}
	}

}
