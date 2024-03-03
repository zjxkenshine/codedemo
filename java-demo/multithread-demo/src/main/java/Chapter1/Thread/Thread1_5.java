package Chapter1.Thread;

public class Thread1_5 extends Thread{
	//数据不共享
	private int count=6;
	public Thread1_5(String name){
		super();
		this.setName(name);
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		super.run();
		while(count>0){
			count--;
			System.out.println("由线程"+this.currentThread().getName()+"计算，count="+count);
		}
	}
}
