package Chapter7.Thread;

public class Thread7_17_1 extends Thread{
	//线程组内处理异常
	
	private String num;
	
	public Thread7_17_1(ThreadGroup group,String name,String num){
		super(group,name);
		this.num=num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int numInt=Integer.parseInt(num);
		while(true){
			System.out.println("死循环中："+Thread.currentThread().getName());
		}
	}

}
