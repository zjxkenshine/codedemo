package Chapter2.Object;

public class Object2_08P {
	//ͬ�������м̳���
	
	synchronized public void MethodA(){
		try{
			System.out.println(" int parent ��һ�� sleep begin threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(" int parent ��һ�� sleep end threadName="+Thread.currentThread().getName()+"time="+System.currentTimeMillis());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
