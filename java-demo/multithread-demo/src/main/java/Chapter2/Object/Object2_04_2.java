package Chapter2.Object;

public class Object2_04_2 {
	//synchronized方法锁的是这个对象而非方法
	
		synchronized public void methodA(){          
			try{
				System.out.println("begin method A threadName="+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("end!");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		synchronized public void methodB(){                   
			//加上synchronized则要等A线程执行完A方法结束后B线程才能执行该方法，对象被锁
			try{
				System.out.println("begin method B threadName="+Thread.currentThread().getName());
				Thread.sleep(2000);
				System.out.println("end!");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
}
