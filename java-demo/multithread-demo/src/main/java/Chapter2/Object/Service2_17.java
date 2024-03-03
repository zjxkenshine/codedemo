package Chapter2.Object;

public class Service2_17 {
	//synchronized(任意非this对象x)结论验证1：      多个线程同时执行synchronized(x){}同步代码块时呈同步效果
	
	public void MethodA(Object2_17 obj){
		synchronized(obj){
			try{
				System.out.println("方法methodA得到锁的时间是"+System.currentTimeMillis()+" 运行线程是"+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("方法methodA释放锁的时间是"+System.currentTimeMillis()+" 运行线程是"+Thread.currentThread().getName());
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
