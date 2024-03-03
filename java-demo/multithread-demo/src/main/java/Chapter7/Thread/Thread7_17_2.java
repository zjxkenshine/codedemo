package Chapter7.Thread;

public class Thread7_17_2 extends Thread{
	//线程组内处理异常
	
	/**如何实现线程组内一个线程异常所有线程停止
	 * 
	 * 注意:使用自定义ThreadGroup线程组并且重写uncaughtException方法处理组内线程中断行为时，每个线程对象内都不能有catch语句，
	 *     如果有，则uncaughtException(Thread t, Throwable e)方法不执行
	 * 
	 * 
	 */
	
	private String num;
	
	public Thread7_17_2(ThreadGroup group,String name,String num) {
		// TODO Auto-generated constructor stub
		super(group,name);
		this.num=num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int numInt=Integer.parseInt(num);
		while(this.isInterrupted()==false){
			System.out.println("死循环中："+Thread.currentThread().getName());
		}
		
	}

}
