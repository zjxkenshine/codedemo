package Chapter2.Object;

public class Object2_29{
	//volatile关键字与死循环
	
	//普通类
	
	private boolean isPrint=true;
	public boolean isPrint(){
		return isPrint;
	}
	
	public void setPrint(boolean a){
		this.isPrint=a;
	}
	
	public void MethodA(){
		try{
			while(isPrint){
				System.out.println("run MethodA threadName="+Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
