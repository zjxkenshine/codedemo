package Chapter2.Object;

public class Object2_04_1 {
	//synchronized方法锁的是这个对象而非方法
	
	synchronized public void methodA(){            //加上synchronized方法锁定对象使线程同步（排队）
		try{
			System.out.println("begin method A threadName="+Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("end!");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
