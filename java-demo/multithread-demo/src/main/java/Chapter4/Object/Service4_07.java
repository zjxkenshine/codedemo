package Chapter4.Object;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service4_07 {
  //ʵ��������/������ģʽ��һ��һ��ӡ
	
	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	private boolean value=false;
	public void set(){
		try{
			lock.lock();
			while(value==true){
				condition.await();
			}
			System.out.println("��ӡ11111111111");
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
			System.out.println("��ӡ22222222222");
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
