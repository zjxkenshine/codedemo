package Chapter2.Object;

public class Object2_28_1 {
	//锁对象的改变
	
	private String lock="123";
	public void testMethod(){
		try{
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" begin"+System.currentTimeMillis());
				lock="456";
				Thread.sleep(2000);                   //这中间执行B线程
				System.out.println(Thread.currentThread().getName()+" end"+System.currentTimeMillis());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
