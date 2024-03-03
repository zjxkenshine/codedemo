package Chapter3.Object;

public class Object3_03_2 {
	//notify()锁不释放
	
	public void Method1(Object lock){
		try{
			synchronized (lock) {
			System.out.println("开始等待的线程是："+Thread.currentThread().getName());
			lock.wait();
			System.out.println("结束等待的线程是："+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void Method2(Object lock){
		try{
			synchronized (lock) {
			System.out.println("开始通知的线程是："+Thread.currentThread().getName());
			lock.notify();
			Thread.sleep(3000);
			System.out.println("结束通知的线程是："+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
