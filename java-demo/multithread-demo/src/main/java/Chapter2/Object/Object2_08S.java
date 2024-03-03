package Chapter2.Object;

public class Object2_08S extends Object2_08P{
	//同步不具有继承性
	
	synchronized public void MethodA(){        //仍要加synchronized，否则不同步
		try{
			System.out.println(" int son 下一步 sleep begin threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(" int son 下一步 sleep end threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
			super.MethodA();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
