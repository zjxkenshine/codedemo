package Chapter4.Object;

import java.util.concurrent.locks.ReentrantLock;

public class Service4_13_2 {
	//tryLock()����
	
	public ReentrantLock lock=new ReentrantLock();
	public void Method(){
		if(lock.tryLock()){
			System.out.println(Thread.currentThread().getName()+" �����");
		}else{
			System.out.println(Thread.currentThread().getName()+" û�л����");
		}
	}

}
