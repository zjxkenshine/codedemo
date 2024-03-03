package Chapter2.Object;

public class Object2_10 {
	//synchronized同步代码块的使用
	
	public void MethodA(){
		try{
			synchronized(this){            //同步代码块
				System.out.println("begin time="+System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("end time="+System.currentTimeMillis());
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
