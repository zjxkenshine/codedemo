package Chapter3.Thread;

public class Thread3_23A extends Thread{
	//方法join()后面的代码提前运行：出现意外
	private Thread3_23B tb;
	
	public Thread3_23A(Thread3_23B tb) {
		// TODO Auto-generated constructor stub
		this.tb=tb;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (tb) {
			System.out.println("begin A ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("end A ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
		}
	}

}
