package Chapter4.Object;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_01 {
	//ʹ��ReentratLockʵ��ͬ��������1
	
	private Lock lock=new ReentrantLock();
	
	public void testMethod(){
		lock.lock();             //����ʼ
		for(int i=0;i<5;i++){
			System.out.println("ThreadName="+Thread.currentThread().getName()+(" "+(i+1)));
		}
		lock.unlock();           //�ͷ���
	}

}
