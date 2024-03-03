package Chapter3.Thread;

public class Thread3_23B extends Thread{
	//方法join()后面的代码提前运行：出现意外
	
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println("begin b ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end b ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
