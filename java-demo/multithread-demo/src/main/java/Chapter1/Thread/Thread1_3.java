package Chapter1.Thread;

public class Thread1_3 extends Thread{
	//线程不确定性：Start方法顺序不是线程执行顺序
	private int i;
	public Thread1_3(int i){
		super();
		this.i=i;
	}
	
	public void run(){
		System.out.println("执行线程"+i);
	}

}
