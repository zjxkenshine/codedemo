package Chapter3.Object;

public class Object3_03_1 {
	//方法wait()锁释放
	
	public void method1(Object lock){
		try{
			synchronized (lock) {
				System.out.println("开始等待");
				lock.wait();
			//	Thread.sleep(1000);              //改为sleep则同步
				System.out.println("结束等待");
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
