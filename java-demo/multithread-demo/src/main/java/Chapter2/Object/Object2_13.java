package Chapter2.Object;

public class Object2_13 {
	//synchronized代码块间的同步性
	
	public void MethodA(){
		try{
			synchronized(this){
				System.out.println("B begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("B end time="+System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void MethodB(){
		try{
			synchronized(this){                                    //对象监视器换成非this就不会和synchronized方法阻塞
				System.out.println("A begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("A end time="+System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	synchronized public void MethodC(){
		try{
			System.out.println("C begin time="+System.currentTimeMillis());
			Thread.sleep(2000);
			System.out.println("C end time="+System.currentTimeMillis());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
