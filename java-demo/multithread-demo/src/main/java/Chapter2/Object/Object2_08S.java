package Chapter2.Object;

public class Object2_08S extends Object2_08P{
	//ͬ�������м̳���
	
	synchronized public void MethodA(){        //��Ҫ��synchronized������ͬ��
		try{
			System.out.println(" int son ��һ�� sleep begin threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(" int son ��һ�� sleep end threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
			super.MethodA();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
