package Chapter3.Object;

public class Object3_04 {
	//interrupt方法遇到wait方法
	
	public void Method(Object lock){
		try{
			synchronized (lock) {
				System.out.println("begin");
				lock.wait();
				System.out.println("end");
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("出现异常了，因为等待状态下线程被停止了");
		}
	}

}
