package Chapter3.Object;

public class Object3_05 {
	//调用方法notify一次只能通知一个线程并唤醒，notifyAll通知所有
	
	public void Method1(Object lock){
		try{
			synchronized (lock) {
				System.out.println("开始等待，线程名"+Thread.currentThread().getName());
				lock.wait();
				System.out.println("结束等待，线程名"+Thread.currentThread().getName());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
