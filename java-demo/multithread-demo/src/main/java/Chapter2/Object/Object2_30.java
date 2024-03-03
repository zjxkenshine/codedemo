package Chapter2.Object;

public class Object2_30 implements Runnable{
	//2_30: volatile解决同步死循环
	
	
	//private boolean isPrint=true;               //运行在-server服务器64位的JVM上会死循环
	
	volatile private boolean isPrint=true;       //使用volatile关键字
	
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		MethodA();
	}
	
	

}
